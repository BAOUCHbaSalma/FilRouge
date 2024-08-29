package com.demo.service;

import com.demo.model.Admin;
import com.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin addAdmin(Admin admin){
        return adminRepository.save(admin);
    }
}
