package com.demo.repository;

import com.demo.model.Evalidation;
import com.demo.model.OrderKey;
import com.demo.model.OrderUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderUserRepository extends JpaRepository<OrderUser, OrderKey> {

    List<OrderUser> findAllByValidationEquals(Evalidation evalidation);
    @Query("SELECT COALESCE(MAX(o.idOrder.orderId), 0) FROM OrderUser o")
    Integer findMaxOrderId();
}
