package com.demo.repository;

import com.demo.model.EAvailability;
import com.demo.model.Reaction;
import com.demo.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReactionRepository extends JpaRepository<Reaction,Integer> {

    List<Reaction> findAllByMeal_Id(Integer id);
    List<Reaction> findAllByUser_Id(Integer id);

}
