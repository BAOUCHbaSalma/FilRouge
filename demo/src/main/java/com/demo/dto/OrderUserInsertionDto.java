package com.demo.dto;

import com.demo.model.OrderKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class OrderUserInsertionDto {
    private Integer mealId;
    private Integer userId;
    private Integer quantity;
    private String address;

    public OrderUserInsertionDto() {
    }

    public OrderUserInsertionDto(Integer mealId, Integer userId, Integer quantity, String address) {
        this.mealId = mealId;
        this.userId = userId;
        this.quantity = quantity;
        this.address = address;
    }
}
