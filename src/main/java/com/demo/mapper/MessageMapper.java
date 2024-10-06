package com.demo.mapper;

import com.demo.dto.MessageMerchantDto;
import com.demo.dto.MessageUserDto;
import com.demo.dto.OrderUserInsertionDto;
import com.demo.model.Message;
import com.demo.model.OrderUser;

public class MessageMapper {
    public static MessageUserDto toDto(Message message){
        MessageUserDto dto=new MessageUserDto();
        return dto;
    }
    public static Message toEntity(MessageUserDto dto){
        Message msg=new Message();
        return msg;
    }
    public static MessageMerchantDto MerchantToDto(Message message){
        MessageMerchantDto dto=new MessageMerchantDto();
        return dto;
    }
    public static Message MerchanttoEntity(MessageMerchantDto dto){
        Message msg=new Message();
        return msg;
    }
}
