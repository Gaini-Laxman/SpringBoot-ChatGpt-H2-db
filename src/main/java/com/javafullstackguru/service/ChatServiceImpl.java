package com.javafullstackguru.service;

import com.javafullstackguru.entity.ChatMessage;
import com.javafullstackguru.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private final ChatMessageRepository chatMessageRepo;

    public ChatServiceImpl(ChatMessageRepository chatMessageRepo) {
        this.chatMessageRepo = chatMessageRepo;
    }

    @Override
    public void saveChatMessage(ChatMessage message) {
        chatMessageRepo.save(message);
    }

    // Implement other business logic methods
}

