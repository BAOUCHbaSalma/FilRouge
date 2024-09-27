package com.demo.dto;

import com.demo.model.EAvailability;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class MealIsertionModificationDto{

    private String name;
    private String picture;
    private Integer price;
    private Integer quantity;

}
