package com.demo.service;

import com.demo.model.User;
import com.demo.repository.AdminRepository;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User adduser(User user){
        user.setDate(LocalDate.now());

        return userRepository.save(user);
    }

    public User findById(Integer id){
        return userRepository.findById(id).orElseThrow();
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
