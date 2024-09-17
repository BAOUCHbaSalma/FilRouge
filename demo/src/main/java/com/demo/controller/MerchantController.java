package com.demo.controller;

import com.demo.model.Merchant;
import com.demo.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @GetMapping("usein/allmerchant")
    public List<Merchant> AllMerchant(){
        return merchantService.findAllMerchant();
    }
}
