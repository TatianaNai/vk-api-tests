package ru.create_chat.services;

import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.messages.responses.CreateChatWithPeerIdsResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateChatApiService {
    private final VkApiClient vk = new VkApiClient(new HttpTransportClient());

    public CreateChatWithPeerIdsResponse createChatResponse(GroupActor group, String title) throws ClientException, ApiException {
        log.info("Send create chat request with group_id: {} and title: {}", group.getGroupId(), title);
        return vk.messages().createChatWithpeerids(group).title(title).execute();
    }

    public void createChatWithoutTitleResponse(GroupActor group) throws ClientException, ApiException {
        log.info("Send create chat request with group_id: {} and without title", group.getGroupId());
        vk.messages().createChatWithpeerids(group).execute();
    }

}
