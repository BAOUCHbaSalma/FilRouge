package com.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderUser {
   @EmbeddedId

    private OrderKey idOrder;

   @ManyToOne
    @MapsId("mealId")
    @JoinColumn
    private Meal meal;


    @ManyToOne
    @MapsId("userId")
    @JoinColumn
    private User user;

    @Column
    private Integer quantity;
    @Column
    private LocalDate date;

    @Column
    private Integer price;
    @Column
    private String address;

    @Enumerated(EnumType.STRING)
   private Evalidation validation;



}
