package com.demo.controller;

import com.demo.dto.MealIsertionModificationDto;
import com.demo.model.Meal;
import com.demo.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class MealController {
    @Autowired
    private MealService mealService;


    @GetMapping("meals/{id}")
    public List<Meal> findMealRestaurant(@PathVariable Integer id){
        return mealService.findMealRestaurant(id);
    }
    @GetMapping("usein/meals/all")
    public List<Meal> findAll(){
        return mealService.findAll();
    }

    @GetMapping("meals/find/{id}")
    public Meal findById(@PathVariable Integer id){
        return mealService.findById(id);
    }

    @PostMapping("merin/meals/{id}")
    public Meal addMeal(@PathVariable Integer id,@RequestBody Meal meal){
        return mealService.addMeal(id,meal);
    }

    @DeleteMapping("merin/meals/{id}")
    public void deleteMeal(@PathVariable Integer id){
         mealService.deleteMeal(id);
    }

    @PutMapping("merin/meals/{id}")
    public Meal updateMeal(@PathVariable Integer id, @RequestBody MealIsertionModificationDto mealIsertionModificationDto){
        return mealService.updateMeal(id,mealIsertionModificationDto);
    }
    @GetMapping("user/meals")
    public List<Meal> meals(){
        return mealService.findMeals();
    }
}
