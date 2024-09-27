package com.demo.controller;

import com.demo.dto.OrderUserDto;
import com.demo.dto.OrderUserInsertionDto;
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


//    @PostMapping("usein/orders")
//    public OrderUser passOrder(@RequestBody OrderUser orderUser){
//        return orderUserService.passeCommande(orderUser);
//    }

    @PostMapping("usein/orders")
    public OrderUser passOrder(@RequestBody OrderUserInsertionDto dto){
        return orderUserService.passeCommande(dto);
    }

//    @GetMapping("merchant/orders/{id}")
//    public OrderUser validationCommande(@PathVariable OrderKey id){
//        return orderUserService.validationCommande(id);
//    }
//
//    @GetMapping("merin/orders/{id}")
//    public OrderUser cancelCommande(@PathVariable OrderKey id){
//        return orderUserService.cancelCommande(id);
//    }
    @GetMapping("/merin/orders/validate")
    public OrderUser validationCommande(@RequestParam Integer orderId, @RequestParam Integer mealId, @RequestParam Integer userId) {
        OrderKey id = new OrderKey(orderId, mealId, userId);
        return orderUserService.validationCommande(id);
    }

    @GetMapping("/merin/orders/cancel")
    public OrderUser cancelCommande(@RequestParam Integer orderId, @RequestParam Integer mealId, @RequestParam Integer userId) {
        OrderKey id = new OrderKey(orderId, mealId, userId);
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

    @GetMapping("merin/orders/restaurant/{id}")
    public List<OrderUser> findByOrdersRestaurant(@PathVariable Integer id){
        return orderUserService.findOrdersByIdRestaurant(id);
    }

    @GetMapping("merin/orders/pending/restaurant/{id}")
    public List<OrderUser> findByOrdersPending(@PathVariable Integer id){
        return orderUserService.findOrdersPending(id);
    }

    @GetMapping("merin/orders/validate/restaurant/{id}")
    public List<OrderUser> findByOrdersValidate(@PathVariable Integer id){
        return orderUserService.findOrdersValidate(id);
    }

    @GetMapping("merin/orders/canceled/restaurant/{id}")
    public List<OrderUser> findByOrdersCanceled(@PathVariable Integer id){
        return orderUserService.findOrdersCanceled(id);
    }








}
