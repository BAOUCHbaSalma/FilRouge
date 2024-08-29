package com.demo.service;

import com.demo.model.Merchant;
import com.demo.model.Restaurant;
import com.demo.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private MerchantService merchantService;

    public List<Restaurant> getRestaurant(double lat ,double lon,double distance){

       return restaurantRepository.findNearbyRestaurants(lat,lon,distance);
    }

    public Restaurant addRestaurant(Integer id,Restaurant restaurant){
        Merchant merchant=merchantService.findById(id);
        restaurant.setMerchant(merchant);
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> findRestaurantsMerchant(Integer idMerchant){
        return restaurantRepository.findAllByMerchant_Id(idMerchant);
    }


}
