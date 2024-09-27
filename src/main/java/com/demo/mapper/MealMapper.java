package com.demo.mapper;

import com.demo.dto.MealIsertionModificationDto;
import com.demo.dto.OrderUserInsertionDto;
import com.demo.model.Meal;
import com.demo.model.OrderUser;

public class MealMapper {
    public static OrderUserInsertionDto toDto(OrderUser orderUser) {
        if (orderUser == null) return null;
        OrderUserInsertionDto dto = new OrderUserInsertionDto();
        return dto;
    }

    public static OrderUser toEntity(OrderUserInsertionDto dto) {
        if (dto == null) return null;
        OrderUser orderUser = new OrderUser();
        return orderUser;
    }

    public static void updateMealFromDto(MealIsertionModificationDto dto, Meal meal) {
        meal.setName(dto.getName());
        meal.setPrice(dto.getPrice());
        meal.setPicture(dto.getPicture());
        meal.setQuantity(dto.getQuantity());
    }

}
