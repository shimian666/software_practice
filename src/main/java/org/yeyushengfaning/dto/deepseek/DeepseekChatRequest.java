package org.yeyushengfaning.dto.deepseek;

import java.util.List;

public record DeepseekChatRequest(String model, List<Message> messages,boolean stream) {
    public record Message(String role, String content) {

    }
}