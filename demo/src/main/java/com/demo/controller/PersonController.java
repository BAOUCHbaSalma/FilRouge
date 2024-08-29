package com.demo.controller;

import com.demo.config.JwtAuth;
import com.demo.dto.LoginRequest;
import com.demo.model.Erole;
import com.demo.model.Person;
import com.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/registre")
    public Person Registre(@RequestBody Person person){
        return personService.Registre(person);
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest person) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(person.getUsername(), person.getPassword())
        );
        Person person1 = personService.findPersonByUsername(person.getUsername());
        Erole role= person1.getRole();
        String token = JwtAuth.generateToken(person.getUsername(),role);
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }
}
