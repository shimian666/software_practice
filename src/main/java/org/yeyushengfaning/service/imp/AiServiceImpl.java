package org.yeyushengfaning.service.imp;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.session.SessionService;
import org.springframework.ai.session.advisor.SessionAdvisors;
import org.springframework.stereotype.Service;
import org.yeyushengfaning.service.AiService;

import static org.yeyushengfaning.constant.PromptConstant.SYSTEM_PROMPT;
import static org.yeyushengfaning.constant.PromptConstant.USER_PROMPT;

@Service
public class AiServiceImpl implements AiService {

    private final ChatClient chatClient;

    public AiServiceImpl(ChatClient.Builder chatClientBuilder, SessionService sessionService) {
        this.chatClient = chatClientBuilder
                .defaultAdvisors(SessionAdvisors.builder(sessionService).build())
                .build();
    }

    @Override
    public String chat(String sessionId, String message) {
        return chatClient.prompt().system(SYSTEM_PROMPT + USER_PROMPT).user(message).advisors(SessionAdvisors.session(sessionId)).call().content();
    }
}