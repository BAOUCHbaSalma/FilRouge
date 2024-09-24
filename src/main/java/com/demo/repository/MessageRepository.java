package com.demo.repository;

import com.demo.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message,Integer> {

    List<Message> findAllByUser_Id(Integer id);

    List<Message> findAllByMerchant_Id(Integer id);
}
