package com.javafullstackguru.service;

import com.javafullstackguru.entity.ChatMessage;
import org.springframework.stereotype.Service;

@Service
public interface ChatService {

    void saveChatMessage(ChatMessage message);

    // Other business logic methods
}

