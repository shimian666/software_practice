package org.yeyushengfaning.service.imp;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.yeyushengfaning.dto.deepseek.DeepseekChatRequest;
import org.yeyushengfaning.dto.deepseek.DeepseekChatResponse;
import org.yeyushengfaning.service.AiService;

import java.util.List;

@Service
public class AiServiceImpl implements AiService {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(AiServiceImpl.class);

    @Resource
    private RestClient restClient;

    @Value("${deepseek.model}")
    private String model;

    @Override
    public String chat(String message) {
        DeepseekChatRequest.Message userMessage = new DeepseekChatRequest.Message("user", message);
        DeepseekChatRequest request = new DeepseekChatRequest(model, List.of(userMessage), false);

        DeepseekChatResponse response = restClient.post()
                .uri("/chat/completions")
                .body(request)
                .retrieve()
                .body(DeepseekChatResponse.class);

        if (response == null || response.choices() == null || response.choices().isEmpty()) {
            log.error("参数错误：模型未返回内容");
            throw new IllegalArgumentException("参数错误：模型未返回内容");
        }
        DeepseekChatResponse.Message reply = response.choices().get(0).message();
        if (reply == null || reply.content() == null || reply.content().isBlank()) {
            log.error("参数错误：模型未返回有效内容");
            throw new IllegalArgumentException("参数错误：模型未返回有效内容");
        }
        return reply.content();
    }
}
