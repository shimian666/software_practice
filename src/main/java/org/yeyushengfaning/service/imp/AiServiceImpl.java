package org.yeyushengfaning.service.imp;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.yeyushengfaning.dto.deepseek.DeepseekChatRequest;
import org.yeyushengfaning.dto.deepseek.DeepseekChatResponse;
import org.yeyushengfaning.service.AiService;

import java.util.List;

@Service
public class AiServiceImpl implements AiService {

    private final ChatClient chatClient;

    public AiServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    private static final String SYSTEM_PROMPT = """
                            你叫%s ，现在是用户的真实伴侣，请完全代入伴侣角色。
                            规则:
                            1. 每次只回1条消息
                            2. 禁止任何场景或状态描述性文字
                            3. 匹配用户的语言
                            4. 回复简短，像微信聊天一样
                            6. 用符合伴侣性格的方式对话
                            7. 回复的内容，要充分体现伴侣的性格特征
                            伴侣性格：
                            - %s
                            你必须严格遵守上述规则来回复用户。
            """;

    @Override
    public String chat(String message) {
        return chatClient.prompt().system(SYSTEM_PROMPT).user(message).call().content();
    }
}