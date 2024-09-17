package com.demo.repository;

import com.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Integer> {

    Person findByUsername(String username);
    @Query("SELECT p.id from Person p where p.username=:username")
    Integer findIdByUsername(@Param("username") String username);


    @Query(value = "select * from Person where role='MERCHANT' or role='USER'",nativeQuery = true)
    List<Person> findUsersAndMerchant();
}
