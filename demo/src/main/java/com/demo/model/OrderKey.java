package com.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderKey implements Serializable {

    @Column
    private Integer orderId;
    @Column
    private Integer mealId;
    @Column
    private Integer userId;


    public OrderKey() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderKey orderKey = (OrderKey) o;
        return Objects.equals(orderId, orderKey.orderId) && Objects.equals(mealId, orderKey.mealId) && Objects.equals(userId, orderKey.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, mealId, userId);
    }
}
