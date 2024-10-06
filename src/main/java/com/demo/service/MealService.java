package com.demo.service;


import com.demo.dto.MealIsertionModificationDto;
import com.demo.mapper.MealMapper;
import com.demo.model.EAvailability;
import com.demo.model.Meal;
import com.demo.model.Reaction;
import com.demo.model.Restaurant;
import com.demo.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private ReactionService reactionService;


    public Meal addMeal(Integer idRestaurant,Meal meal){
        Restaurant restaurant=restaurantService.findById(idRestaurant);
        meal.setRestaurant(restaurant);
        return mealRepository.save(meal);
    }

    public List<Meal> findMealRestaurant(Integer idRestaurant){
        return mealRepository.findAllByRestaurant_IdRestaurant(idRestaurant);
    }

    public List<Meal> findAll(){
        return mealRepository.findAll();
    }

    public void deleteMeal(Integer id){
        mealRepository.deleteById(id);
    }

    public Meal findById(Integer idMeal){
        return mealRepository.findById(idMeal).orElseThrow();
    }

    public Meal updateMeal(Integer idMeal, MealIsertionModificationDto mealIsertionModificationDto){
        Meal meal=findById(idMeal);
        MealMapper.updateMealFromDto(mealIsertionModificationDto,meal);
        if(mealIsertionModificationDto.getQuantity()>0){
            meal.setAvailability(EAvailability.AVAILABLE);
        }
        return mealRepository.save(meal);
    }
    public List<Meal> findMeals(){
        return mealRepository.findByMealAvailability(EAvailability.AVAILABLE);
    }
}
