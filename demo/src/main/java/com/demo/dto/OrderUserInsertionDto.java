package com.demo.dto;

import com.demo.model.OrderKey;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderUserInsertionDto {
    private Integer mealId;
    private Integer userId;
    private Integer quantity;
    private String address;
}
