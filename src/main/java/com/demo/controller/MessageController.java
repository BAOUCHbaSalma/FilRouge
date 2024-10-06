package com.demo.controller;

import com.demo.dto.MessageMerchantDto;
import com.demo.dto.MessageUserDto;
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

    @PostMapping("user/messages")
    public Message sendMessageToMerchant(@RequestBody MessageUserDto message){
        return messageService.sendMessageToMerchant(message);
    }

    @PostMapping("merchant/messages/{id}")
    public Message sendMessageToUser(@PathVariable Integer id,@RequestBody MessageMerchantDto message){
        System.out.println("//////////id"+id);
        System.out.println("/////merchantmessage"+message.getContentMerchant());
        System.out.println("/////merchantmessage"+message.getSubjectMerchant());
        return messageService.sendMessageToUser(id,message);
    }

    @GetMapping("meruser/message/{id}")
    public Message messageDetails(@PathVariable Integer id){
        return messageService.findById(id);
    }
}
