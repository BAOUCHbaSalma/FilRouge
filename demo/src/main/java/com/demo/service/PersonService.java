package com.demo.service;

import com.demo.model.*;
import com.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Person Registre(Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        if (person.getRole()== Erole.MERCHANT){
            return merchantService.addMerchant((Merchant) person);
        }
        else if (person.getRole()==Erole.USER) {
            return userService.adduser((User) person);

        }
        else if(person.getRole()==Erole.ADMIN){
            return adminService.addAdmin((Admin) person);
        }
        else {
            return null;
        }

    }

    public Person findPersonByUsername(String username){
        return personRepository.findByUsername(username);
    }


}
