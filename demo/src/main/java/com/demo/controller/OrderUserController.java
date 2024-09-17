package com.demo.controller;

import com.demo.dto.OrderUserDto;
import com.demo.model.OrderKey;
import com.demo.model.OrderUser;
import com.demo.service.OrderUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class OrderUserController {

    @Autowired
    private OrderUserService orderUserService;


    @PostMapping("usein/orders")
    public OrderUser passOrder(@RequestBody OrderUser orderUser){
        return orderUserService.passeCommande(orderUser);
    }

    @GetMapping("merchant/orders/{id}")
    public OrderUser validationCommande(@PathVariable OrderKey id){
        return orderUserService.validationCommande(id);
    }

    @GetMapping("merin/orders/{id}")
    public OrderUser cancelCommande(@PathVariable OrderKey id){
        return orderUserService.cancelCommande(id);
    }

    @GetMapping("admin/orders")
    public List<OrderUser> findAllOrders(){
        return orderUserService.findAll();
    }

    @GetMapping("admin/orders/pending")
    public List<OrderUser> findOrdersPending(){
        return orderUserService.findOrderPending();
    }

    @GetMapping("admin/orders/validate")
    public List<OrderUser> findOrdersValidate(){
        return orderUserService.findOrderValidate();
    }

    @GetMapping("admin/orders/cancel")
    public List<OrderUser> findOrdersCancel(){
        return orderUserService.findOrderCancel();
    }








}
