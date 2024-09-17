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
    private PasswordEncoder passwordEncoder;

    public Person Signup(Person person){
        if (person.getRole() == Erole.MERCHANT) {
            Merchant merchant = new Merchant();
            merchant.setUsername(person.getUsername());
            merchant.setEmail(person.getEmail());
            merchant.setPassword(passwordEncoder.encode(person.getPassword()));
            merchant.setRole(person.getRole());
            return personRepository.save(merchant);

        } else if (person.getRole() == Erole.USER) {
            User user = new User();
            user.setUsername(person.getUsername());
            user.setEmail(person.getEmail());
            user.setPassword(passwordEncoder.encode(person.getPassword()));
            user.setRole(person.getRole());
            return personRepository.save(user);
        }
        return person;

    }

    public Person findPersonByUsername(String username){
        return personRepository.findByUsername(username);
    }

    public Integer findIdByUsername(String username){
        return personRepository.findIdByUsername(username);
    }


}
