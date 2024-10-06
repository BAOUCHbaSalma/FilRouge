package com.demo.repository;

import com.demo.model.EAvailability;
import com.demo.model.Meal;
import com.demo.model.Reaction;
import com.demo.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal,Integer> {

    List<Meal> findAllByRestaurant_IdRestaurant(Integer id);
    @Query("select m from Meal m where m.availability = :avl")
    List<Meal> findByMealAvailability(@Param("avl") EAvailability availability);

}
