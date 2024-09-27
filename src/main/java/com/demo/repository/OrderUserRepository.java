package com.demo.repository;

import com.demo.dto.OrderUserDto;
import com.demo.model.Evalidation;
import com.demo.model.OrderKey;
import com.demo.model.OrderUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderUserRepository extends JpaRepository<OrderUser, OrderKey> {

    List<OrderUser> findAllByValidationEquals(Evalidation evalidation);
    @Query("SELECT COALESCE(MAX(o.idOrder.orderId), 0) FROM OrderUser o")
    Integer findMaxOrderId();
    List<OrderUser> findByMeal_Restaurant_IdRestaurant(Integer idRestaurant);
    @Query("select o from OrderUser o inner join Meal m on m.id = o.meal.id inner join Restaurant r on r.idRestaurant = m.restaurant.idRestaurant where o.validation = :validation and r.idRestaurant = :idRestaurant")
    List<OrderUser> findByRestaurantAndValidation(@Param("validation") Evalidation validation, @Param("idRestaurant") Integer idRestaurant);

}
