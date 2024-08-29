package com.demo.controller;

import com.demo.model.Restaurant;
import com.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/nearby")
    public
    List<Restaurant> getNearbyRestaurants(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam double distance) {
        return restaurantService.getRestaurant(latitude, longitude, distance);
    }

    @PostMapping("merin/restaurants/{id}")
    public Restaurant addRestaurant(@PathVariable Integer id , @RequestBody Restaurant restaurant){
        return restaurantService.addRestaurant(id,restaurant);
    }
    @GetMapping("usein/restaurants")
    public List<Restaurant> findAllRestaurants(){
        return restaurantService.findAllRestaurants();
    }
}
