package com.demo.controller;

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





}
