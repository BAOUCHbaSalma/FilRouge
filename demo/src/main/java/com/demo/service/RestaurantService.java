package com.demo.service;

import com.demo.model.Restaurant;
import com.demo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    public List<Restaurant> getRestaurant(double lat ,double lon,double distance){

       return restaurantRepository.findNearbyRestaurants(lat,lon,distance);
    }
}
