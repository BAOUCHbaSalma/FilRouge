package com.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderKey implements Serializable {

    @JsonProperty("orderId")
    private Integer orderId;

    @JsonProperty("mealId")
    private Integer mealId;

    @JsonProperty("userId")
    private Integer userId;

    public OrderKey(Integer orderId, Integer mealId, Integer userId) {
        this.orderId = orderId;
        this.mealId = mealId;
        this.userId = userId;
    }

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
