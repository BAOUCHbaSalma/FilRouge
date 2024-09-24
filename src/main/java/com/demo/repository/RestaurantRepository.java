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
    List<Restaurant> findAllByMerchant_Id(Integer id);
    @Query(value = "SELECT r.id_restaurant AS Id, r.name AS Name, r.ville AS Ville, " +
            "COALESCE(COUNT(CASE WHEN o.validation = 'VALIDATE' THEN 1 END), 0) AS repasLivres, " +
            "COALESCE(COUNT(CASE WHEN o.validation = 'CANCELLED' THEN 1 END), 0) AS repasAnnules " +
            "FROM restaurant r " +
            "LEFT JOIN meal m ON m.restaurant_id = r.id_restaurant " +
            "LEFT JOIN order_user o ON o.meal_id = m.id " +
            "GROUP BY r.id_restaurant, r.name, r.ville",
            nativeQuery = true)
    List<Object[]> listRestaurantsAdmin();
    }