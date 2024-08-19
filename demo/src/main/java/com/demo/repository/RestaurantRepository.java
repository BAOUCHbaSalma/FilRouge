package com.demo.repository;

import com.demo.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {

    @Query(value = "SELECT * FROM restaurant WHERE ST_Distance_Sphere(POINT(longitude, latitude), POINT(:longitude, :latitude)) <= :distance", nativeQuery = true)
    List<Restaurant> findNearbyRestaurants(
            @Param("latitude") double latitude,
            @Param("longitude") double longitude,
            @Param("distance") double distance
    );
    }

