package com.demo.service;

import com.demo.model.Merchant;
import com.demo.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {

    @Autowired
    private MerchantRepository merchantRepository;


    public Merchant findById(Integer id){
        return merchantRepository.findById(id).orElseThrow();
    }

    public Merchant addMerchant(Merchant merchant){
        return merchantRepository.save(merchant);
    }
}
