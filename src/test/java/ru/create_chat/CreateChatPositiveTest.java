package ru.create_chat;

import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.create_chat.services.CreateChatApiService;
import ru.create_chat.utils.Props;

import static org.testng.AssertJUnit.*;
import static ru.create_chat.utils.RandomGenerator.*;

@Slf4j
public class CreateChatPositiveTest {
    private static final CreateChatApiService API_SERVICE = new CreateChatApiService();

    @DataProvider()
    public Object[][] titleProvider() {
        return new Object[][]{
                {new GroupActor(Long.parseLong(Props.getProperty("groupId1")),
                        Props.getProperty("accessToken1")),
                        randomStringWithLength(randomIntWithBorders(1, 200))},
                {new GroupActor(Long.parseLong(Props.getProperty("groupId2")),
                        Props.getProperty("accessToken2")),
                        randomStringWithLength(randomIntWithBorders(200, 300))}
        };
    }

    @Test(
            description = "Create chat positive test",
            dataProvider = "titleProvider",
            groups = {"positive", "smoke"})
    public void shouldHaveCorrectCreateChat(GroupActor group, String title) throws ClientException, ApiException {
        log.info("Check if chat id is not null");
        assertNotNull(API_SERVICE.createChatResponse(group, title).getChatId());
    }
}
