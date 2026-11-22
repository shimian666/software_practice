package org.yeyushengfaning.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yeyushengfaning.common.ApiResponse;
import org.yeyushengfaning.service.AiService;

@RestController
@RequestMapping("/ai")
public class AiController {

    @Resource
    private AiService aiService;

    @RequestMapping("/chat")
    public ApiResponse<String> chat(String message) {
        String response = aiService.chat(message);
        return ApiResponse.success(response);
    }
}
