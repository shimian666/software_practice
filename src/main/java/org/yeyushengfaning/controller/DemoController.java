package org.yeyushengfaning.controller;

import jakarta.annotation.Resource;
import org.yeyushengfaning.common.ApiResponse;
import org.yeyushengfaning.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Resource
    private HelloService helloService;

    @GetMapping("/health")
    public ApiResponse<String> health() {
        return ApiResponse.success(helloService.sayHello());
    }

}
