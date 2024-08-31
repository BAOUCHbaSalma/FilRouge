package com.demo.service;

import com.demo.model.*;
import com.demo.repository.OrderUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderUserService {

    @Autowired
    private OrderUserRepository orderUserRepository;
    @Autowired
    private MealService mealService;



    public OrderUser passeCommande(OrderUser orderUser){
        Integer id=orderUserRepository.findMaxOrderId()+1;
       Integer idMeal=orderUser.getMeal().getId();
       Integer idUser=orderUser.getUser().getId();
      OrderKey orderKey=new OrderKey(id,idMeal,idUser);
      orderUser.setIdOrder(orderKey);
      Meal meal=mealService.findById(orderUser.getMeal().getId());
      orderUser.setPrice(meal.getPrice()* orderUser.getQuantity());
        orderUser.setValidation(Evalidation.PENDING);

        if(meal.getQuantity()!=0){
          Integer qt=  meal.getQuantity()-orderUser.getQuantity();
          meal.setQuantity(qt);
          if(meal.getQuantity()==0){
              meal.setAvailability(EAvailability.UNAVAILABLE);
          }

        }
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

    public List<OrderUser> findOrderPending(){
        return orderUserRepository.findAllByValidationEquals(Evalidation.PENDING);
    }

    public List<OrderUser> findOrderValidate(){
        return orderUserRepository.findAllByValidationEquals(Evalidation.VALIDATE);
    }
    public List<OrderUser> findOrderCancel(){
        return orderUserRepository.findAllByValidationEquals(Evalidation.CANCEL);
    }




}
