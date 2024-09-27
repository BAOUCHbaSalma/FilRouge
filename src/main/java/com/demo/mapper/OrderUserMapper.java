package com.demo.mapper;

import com.demo.dto.OrderUserDto;
import com.demo.dto.OrderUserInsertionDto;
import com.demo.model.OrderUser;

public class OrderUserMapper {
    public static OrderUserDto toDto(Object[] result) {
        OrderUserDto dto = new OrderUserDto();
        dto.setId(((Number) result[0]).intValue());
        dto.setName((String) result[1]);
        dto.setVille((String) result[2]);
        dto.setRepas_livres(((Number) result[3]).intValue());
        dto.setRepas_annules(((Number) result[4]).intValue());

        return dto;
    }

    public static OrderUserInsertionDto toDto(OrderUser orderUser) {
        OrderUserInsertionDto dto=new OrderUserInsertionDto();
        dto.setMealId(orderUser.getMeal().getId());
        dto.setUserId(orderUser.getUser().getId());
        dto.setQuantity(orderUser.getQuantity());
        dto.setAddress(orderUser.getAddress());
        return dto;
    }

    public static OrderUser toEntity(OrderUserInsertionDto dto) {
        OrderUser orderUser = new OrderUser();
        orderUser.setQuantity(dto.getQuantity());
        orderUser.setAddress(dto.getAddress());
        return orderUser;
    }
}
