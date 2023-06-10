package com.example.service;

import com.example.models.Message;
import com.example.models.User;
import com.example.models.dto.MessageDto;
import com.example.repos.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Page<MessageDto> messageList(Pageable pageable, String filter, User user) {
        if (filter != null && !filter.isEmpty()) {
            return (messageRepository.findByTag(filter, pageable, user));
        } else {
            return (messageRepository.findAll(pageable, user));
        }
    }

    public Page<MessageDto> messageListForUser(Pageable pageable, User author, User currentUser) {
        return messageRepository.findByUser(pageable, author, currentUser);
    }
}
