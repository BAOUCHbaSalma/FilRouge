package com.demo.repository;

import com.demo.model.OrderKey;
import com.demo.model.OrderUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderUserRepository extends JpaRepository<OrderUser, OrderKey> {
}
