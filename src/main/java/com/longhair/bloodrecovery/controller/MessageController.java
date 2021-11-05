package com.longhair.bloodrecovery.controller;

import com.longhair.bloodrecovery.domain.Message;
import com.longhair.bloodrecovery.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<Message>> getMessages(@PathVariable("userId")String userId){
        return new ResponseEntity<>(messageService.getAllMessageList(userId), HttpStatus.OK);
    }

    @GetMapping("/read/{userId}")
    public ResponseEntity<List<Message>> getReadMessages(@PathVariable("userId")String userId){
        return new ResponseEntity<>(messageService.getReadMessageList(userId), HttpStatus.OK);
    }

    @GetMapping("/unread/{userId}")
    public ResponseEntity<List<Message>> getUnReadMessages(@PathVariable("userId")String userId){
        return new ResponseEntity<>(messageService.getUnReadMessageList(userId), HttpStatus.OK);
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable("id")Long id){
        return new ResponseEntity<>(messageService.getMessage(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Message> postMessage(@RequestBody Message message){
        return new ResponseEntity<>(messageService.sendMessage(message), HttpStatus.OK);
    }

    @DeleteMapping("/one/{id}")
    public void deleteMessage(@PathVariable("id")Long id){
        messageService.deleteMessage(id);
    }

    @DeleteMapping("/{userId}")
    public void deleteAllMessage(@PathVariable("userId")String userId){
        messageService.deleteAllMessages(userId);
    }

    @DeleteMapping("/read/{userId}")
    public void deleteAllReadMessage(@PathVariable("userId")String userId){
        messageService.deleteAllReadMessage(userId);
    }
}
