package com.demo.repository;

import com.demo.dto.OrderUserDto;
import com.demo.model.Evalidation;
import com.demo.model.OrderKey;
import com.demo.model.OrderUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderUserRepository extends JpaRepository<OrderUser, OrderKey> {

    List<OrderUser> findAllByValidationEquals(Evalidation evalidation);
    @Query("SELECT COALESCE(MAX(o.idOrder.orderId), 0) FROM OrderUser o")
    Integer findMaxOrderId();
//    @Query(value = "SELECT r.id_restaurant AS Id, r.name AS Name, r.ville AS Ville, COUNT(CASE WHEN o.validation = 'VALIDATE' THEN 1 END) AS repas_livres, COUNT(CASE WHEN o.validation = 'CANCELLED' THEN 1 END) AS repas_annules FROM order_user o INNER JOIN meal m ON m.id = o.meal_id INNER JOIN restaurant r ON r.id_restaurant = m.restaurant_id GROUP BY r.id_restaurant, r.name, r.ville",nativeQuery = true)
//    List<Object[]> listRestaurantsAdmin();
}
