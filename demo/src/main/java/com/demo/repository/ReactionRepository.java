package com.demo.repository;

import com.demo.model.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReactionRepository extends JpaRepository<Reaction,Integer> {

    List<Reaction> findAllByMeal_Id(Integer id);
}
