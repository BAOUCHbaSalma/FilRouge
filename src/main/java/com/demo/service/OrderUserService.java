package com.demo.service;

import com.demo.mapper.OrderUserMapper;
import com.demo.dto.OrderUserInsertionDto;
import com.demo.model.*;
import com.demo.repository.MealRepository;
import com.demo.repository.OrderUserRepository;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderUserService {

    @Autowired
    private OrderUserRepository orderUserRepository;
    @Autowired
    private MealService mealService;
    @Autowired
    private UserService userService;
    @Autowired
    private MealRepository mealRepository;


    public OrderUser passeCommande(OrderUserInsertionDto dto){
        Integer id=orderUserRepository.findMaxOrderId()+1;
        Integer idMeal= dto.getMealId();
        Integer idUser=dto.getUserId();
        OrderKey orderKey=new OrderKey(id,idMeal,idUser);
        OrderUser orderUser=OrderUserMapper.toEntity(dto);
        orderUser.setIdOrder(orderKey);
        Meal meal=mealService.findById(dto.getMealId());
        User user=userService.findById(dto.getUserId());
        orderUser.setUser(user);
        orderUser.setMeal(meal);
        orderUser.setDate(LocalDate.now());
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
        Meal meal=mealService.findById(orderUser.getMeal().getId());
        if(orderUser.getValidation()==Evalidation.PENDING){
            orderUser.setValidation(Evalidation.CANCELLED);
            meal.setQuantity(meal.getQuantity() + orderUser.getQuantity());
            meal.setAvailability(EAvailability.AVAILABLE);
            mealRepository.save(meal);

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
        return orderUserRepository.findAllByValidationEquals(Evalidation.CANCELLED);
    }

    public List<OrderUser> findOrdersByIdRestaurant(Integer idRestaurant){
       List<OrderUser> oders= orderUserRepository.findByMeal_Restaurant_IdRestaurant(idRestaurant);
       oders.forEach(orderUser -> System.out.println("/////// "+orderUser.getIdOrder().toString()));
       return oders;
    }

    public List<OrderUser> findOrdersPending(Integer idRestaurant){
        List<OrderUser> orderUsers= orderUserRepository.findByRestaurantAndValidation(Evalidation.PENDING,idRestaurant);
        orderUsers.forEach(orderUser -> System.out.println("mmmmmmmmmmmmm ////// "+orderUser.getIdOrder().toString()));
        return orderUsers;
    }

    public List<OrderUser> findOrdersValidate(Integer idRestaurant){
        return orderUserRepository.findByRestaurantAndValidation(Evalidation.VALIDATE,idRestaurant);
    }
    public List<OrderUser> findOrdersCanceled(Integer idRestaurant){
        return orderUserRepository.findByRestaurantAndValidation(Evalidation.CANCELLED,idRestaurant);
    }
    public List<OrderUser> findByIdUser(Integer id){
        return orderUserRepository.findByUser_Id(id);
    }
}
