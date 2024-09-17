package com.demo.repository;

import com.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person,Integer> {

    Person findByUsername(String username);
    @Query("SELECT p.id from Person p where p.username=:username")
    Integer findIdByUsername(@Param("username") String username);
}
