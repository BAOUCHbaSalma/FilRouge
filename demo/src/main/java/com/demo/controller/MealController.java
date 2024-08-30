package com.demo.controller;

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
    @GetMapping("meals/all")
    public List<Meal> findAll(){
        return mealService.findAll();
    }

    @GetMapping("meals/find/{id}")
    public Meal findById(@PathVariable Integer id){
        return mealService.findById(id);
    }

    @PostMapping("meals/{id}")
    public Meal addMeal(@PathVariable Integer id,Meal meal){
        return mealService.addMeal(id,meal);
    }

    @DeleteMapping("meals/{id}")
    public void deleteMeal(@PathVariable Integer id){
         mealService.deleteMeal(id);
    }

    @PutMapping("meals/{id}")
    public Meal updateMeal(@PathVariable Integer id,@RequestBody Meal meal){
        return mealService.updateMeal(id,meal);
    }
}
