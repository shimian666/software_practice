package org.yeyushengfaning.controller;

import org.yeyushengfaning.common.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HealthController {

    @GetMapping("/healthcheck")
    public ApiResponse<String> health() {
        return ApiResponse.success("测试服务是否活着");
    }

}