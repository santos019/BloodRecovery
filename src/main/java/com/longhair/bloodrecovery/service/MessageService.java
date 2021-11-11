package com.longhair.bloodrecovery.service;

import com.longhair.bloodrecovery.domain.Message;
import com.longhair.bloodrecovery.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    @Transactional(readOnly = true)
    public List<Message> getAllMessageList(String userId){
        return messageRepository.findAllByConsumer(userId);
    }

    @Transactional(readOnly = true)
    public List<Message> getAllSendMessageList(String userId){
        return messageRepository.findAllByProducer(userId);
    }

    @Transactional(readOnly = true)
    public List<Message> getReadMessageList(String userId){
        return messageRepository.findAllByConsumerAndRead(userId, true);
    }

    @Transactional(readOnly = true)
    public List<Message> getUnReadMessageList(String userId){
        return messageRepository.findAllByConsumerAndRead(userId, false);
    }

    @Transactional
    public Message getMessage(Long id){
        Message item = messageRepository.findById(id).orElseGet(Message::new);
        item.setRead(true);
        messageRepository.save(item);
        return item;
    }

    @Transactional
    public Message sendMessage(Message message){
        message.setDate(LocalDateTime.now());
        message.setRead(false);
        return messageRepository.save(message);
    }

    @Transactional
    public void deleteMessage(Long id){
        messageRepository.deleteById(id);
    }

    @Transactional
    public void deleteAllMessages(String userId){
        messageRepository.deleteAllByConsumer(userId);
    }

    @Transactional
    public void deleteAllReadMessage(String userId){
        messageRepository.deleteAllByConsumerAndRead(userId, true);
    }
}
