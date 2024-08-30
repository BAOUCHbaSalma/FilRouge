package com.demo.controller;

import com.demo.model.Message;
import com.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class MessageController {

    @Autowired
    private MessageService messageService;


    @GetMapping("usein/messages/user/{id}")
    public List<Message> findByUser(@PathVariable Integer id){
        return messageService.findAllByUser(id);
    }

    @GetMapping("merin/messages/merchant/{id}")
    public List<Message> findByMerchant(@PathVariable Integer id){
        return messageService.findAllByMerchant(id);
    }

    @PostMapping("messages")
    public Message sendMessage(@RequestBody Message message){
        return messageService.addMessage(message);
    }
}
