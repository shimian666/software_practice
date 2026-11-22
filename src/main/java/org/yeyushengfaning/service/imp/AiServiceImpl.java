package org.yeyushengfaning.service.imp;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.yeyushengfaning.dto.deepseek.DeepseekChatRequest;
import org.yeyushengfaning.dto.deepseek.DeepseekChatResponse;
import org.yeyushengfaning.service.AiService;

import java.util.List;

@Service
public class AiServiceImpl implements AiService {
    @Resource
    private RestClient restClient;

    @Value("${deepseek.model}")
    private String model;

    @Override
    public String chat(String message) {
        //构造用户信息
        DeepseekChatRequest.Message userMessage = new DeepseekChatRequest.Message("user", message);
        //构造api请求对象
        DeepseekChatRequest request = new DeepseekChatRequest(model, List.of(userMessage), false);
        //调用api
        DeepseekChatResponse response = restClient.post().uri("/chat/completions").body(request).retrieve().body(DeepseekChatResponse.class);

        //壮硕性判断
        if (response.choices().isEmpty()
        || response.choices().get(0).content() == null
                || response.choices().get(0).content().isEmpty()){
            return "我不知道你在说什么";
        }
        //获取ai回答
        return response.choices().get(0).content();
    }
}
