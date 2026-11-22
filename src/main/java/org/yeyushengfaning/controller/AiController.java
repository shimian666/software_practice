package org.yeyushengfaning.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yeyushengfaning.common.ApiResponse;
import org.yeyushengfaning.dto.ChatRequest;
import org.yeyushengfaning.service.AiService;

@RestController
@RequestMapping("/ai")
public class AiController {

    @Resource
    private AiService aiService;

    @PostMapping("/chat")
    public ApiResponse<String> chat(@RequestBody ChatRequest chatRequest) {
        String message = chatRequest.getMessage();
        if (message == null || message.isBlank()) {
            return ApiResponse.fail("message 不能为空");
        }
        return ApiResponse.success(aiService.chat(message));
    }
}