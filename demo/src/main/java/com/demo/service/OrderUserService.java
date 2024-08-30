package com.demo.service;

import com.demo.model.Evalidation;
import com.demo.model.OrderKey;
import com.demo.model.OrderUser;
import com.demo.repository.OrderUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderUserService {

    @Autowired
    private OrderUserRepository orderUserRepository;

    public OrderUser passeCommande(OrderUser orderUser){
        orderUser.setValidation(Evalidation.PENDING);
        return orderUserRepository.save(orderUser);
    }

    public OrderUser findById(OrderKey id){
        return orderUserRepository.findById(id).orElseThrow();
    }

    public OrderUser validationCommande(OrderKey id){
        OrderUser orderUser=findById(id);
        orderUser.setValidation(Evalidation.VALIDATE);
        return orderUserRepository.save(orderUser);

    }
    public OrderUser cancelCommande(OrderKey id){
        OrderUser orderUser=findById(id);
        if(orderUser.getValidation()==Evalidation.PENDING){
            orderUser.setValidation(Evalidation.CANCEL);
            return orderUserRepository.save(orderUser);

        }else {
            return orderUser;
        }

    }
    public List<OrderUser> findAll(){
        return orderUserRepository.findAll();
    }

    


}
