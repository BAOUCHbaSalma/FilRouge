package com.demo.service;


import com.demo.dto.MessageMerchantDto;
import com.demo.dto.MessageUserDto;
import com.demo.mapper.MessageMapper;
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

    public Message sendMessageToMerchant(MessageUserDto message){
        Message msg=MessageMapper.toEntity(message);
        return messageRepository.save(msg);
    }
    public Message sendMessageToUser(Integer idMessage,MessageMerchantDto message){
        Message messagefind=findById(idMessage);
        messagefind.setContentMerchant(message.getContentMerchant());
        messagefind.setSubjectMerchant(message.getSubjectMerchant());
        return messageRepository.save(messagefind);
    }
    public List<Message> findAllByUser(Integer id){
        return messageRepository.findAllByUser_Id(id);
    }

    public List<Message> findAllByMerchant(Integer id){
        return messageRepository.findAllByMerchant_IdAndContentMerchantIsNull(id);
    }
    public Message findById(Integer id){
        return messageRepository.findById(id).orElseThrow();
    }
}
