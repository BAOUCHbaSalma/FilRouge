package com.demo.service;

import com.demo.model.User;
import com.demo.repository.AdminRepository;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User adduser(User user){
        return userRepository.save(user);
    }
}
