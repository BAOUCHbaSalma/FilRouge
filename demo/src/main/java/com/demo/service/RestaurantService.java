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

    public List<Restaurant> findAllRestaurants(){
        return restaurantRepository.findAll();
    }

    public void deleteRestaurant(Integer id){
         restaurantRepository.deleteById(id);
    }

    public Restaurant findById(Integer id){
        return restaurantRepository.findById(id).orElseThrow();
    }

    public Restaurant updateRestaurant(Integer idRestaurant,Restaurant restaurant){
        Restaurant restaurant1=findById(idRestaurant);
        restaurant1.setLatitude(restaurant.getLatitude());
        restaurant1.setLongitude(restaurant.getLongitude());
        restaurant1.setName(restaurant.getName());
        restaurant1.setVille(restaurant.getVille());

        return restaurantRepository.save(restaurant1);
    }


}
