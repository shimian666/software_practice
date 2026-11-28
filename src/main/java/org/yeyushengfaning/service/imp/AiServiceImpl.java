package org.yeyushengfaning.service.imp;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import org.yeyushengfaning.service.AiService;

import static org.yeyushengfaning.constant.PromptConstant.SYSTEM_PROMPT;
import static org.yeyushengfaning.constant.PromptConstant.USER_PROMPT;

@Service
public class AiServiceImpl implements AiService {

    private final ChatClient chatClient;

    public AiServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @Override
    public String chat(String message) {
        return chatClient.prompt().system(SYSTEM_PROMPT).user(USER_PROMPT).advisors().call().content();
    }
}