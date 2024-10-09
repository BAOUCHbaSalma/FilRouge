package com.demo.dto;

import com.demo.model.Meal;
import com.demo.model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReactionDto {
    private Integer mealId;
    private Integer userId;
    private String comment;
    private Integer likes;
}

