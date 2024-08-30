package com.demo.service;


import com.demo.model.Message;
import com.demo.model.User;
import com.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserService userService;

    public Message addMessage(Integer idUser ,Message message){
        User user=userService.findById(idUser);
        message.setUser(user);
        return messageRepository.save(message);
    }

    public List<Message> findAllByUser(Integer id){
        return messageRepository.findAllByUser_Id(id);
    }

    public List<Message> findAllByMerchant(Integer id){
        return messageRepository.findAllByMerchant_Id(id);
    }



}
