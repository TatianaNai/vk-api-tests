package ru.create_chat;

import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ApiExtendedException;
import com.vk.api.sdk.exceptions.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import ru.create_chat.consts.VkApiErrors;
import ru.create_chat.services.CreateChatApiService;
import ru.create_chat.utils.Props;

import static org.testng.AssertJUnit.*;
import static ru.create_chat.utils.RandomGenerator.randomIntWithBorders;
import static ru.create_chat.utils.RandomGenerator.randomStringWithLength;

@Slf4j
public class CreateChatNegativeTest {
    private static final CreateChatApiService API_SERVICE = new CreateChatApiService();
    private static final GroupActor GROUP = new GroupActor(Long.parseLong(Props.getProperty("groupId1")),
            Props.getProperty("accessToken1"));

    @Test(
            description = "Create chat without title negative test",
            expectedExceptions = ApiExtendedException.class,
            groups = {"negative"})
    public void shouldHaveExceptionByCreatingChatWithoutTitle() throws ClientException, ApiException {
        API_SERVICE.createChatWithoutTitleResponse(GROUP);
    }

    @Test(
            description = "Create chat with empty title negative test",
            expectedExceptions = ApiExtendedException.class,
            groups = {"negative"})
    public void shouldHaveExceptionByCreatingChatWithEmptyTitle() throws ClientException, ApiException {
        API_SERVICE.createChatResponse(GROUP, "");
    }

    @Test(
            description = "Create chat with invalid access token negative test",
            groups = {"negative", "smoke"})
    public void shouldHaveExceptionByCreatingChatWithInvalidAccessToken() throws ClientException {
        GroupActor groupWithRandomToken = new GroupActor(Long.parseLong(Props.getProperty("groupId1")),
                randomStringWithLength(220));
        String title = randomStringWithLength(randomIntWithBorders(1, 200));
        try{
            API_SERVICE.createChatResponse(groupWithRandomToken, title);
            fail("Expected exception ApiException was not thrown");
        }
        catch(ApiException e) {
            log.info("Check massage of ApiException");
            assertEquals(VkApiErrors.FAILED_AUTHORIZATION, e.getMessage());
        }
    }
}
