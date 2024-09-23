package com.demo.repository;

import com.demo.model.Meal;
import com.demo.model.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal,Integer> {

    List<Meal> findAllByRestaurant_IdRestaurant(Integer id);

}
