package com.demo.service;


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
//       List<Meal> mealList=mealRepository.findAll();
//       for (Meal meal:mealList){
//           List<Reaction> reaction=reactionService.findReactionMeal(meal.getId());
//           meal.setReactionList(reaction);
//       }
//       return mealList;
        return mealRepository.findAll();

    }

    public void deleteMeal(Integer id){
        mealRepository.deleteById(id);
    }

    public Meal findById(Integer idMeal){
        return mealRepository.findById(idMeal).orElseThrow();
    }

    public Meal updateMeal(Integer idMeal,Meal meal){
        Meal meal1=findById(idMeal);
        meal1.setName(meal.getName());
        meal1.setPrice(meal.getPrice());
        meal1.setPicture(meal.getPicture());
        meal1.setQuantity(meal.getQuantity());
        meal1.setAvailability(meal.getAvailability());
        return mealRepository.save(meal1);


    }

}
