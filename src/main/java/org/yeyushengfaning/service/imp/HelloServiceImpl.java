package org.yeyushengfaning.service.imp;

import org.yeyushengfaning.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello() {
        return "你好！这是我开发的AI智能体";
    }

}
