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
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/registre")
    public Person Signup(@RequestBody Person person){
        return personService.Signup(person);
    }


    @PostMapping("/login")
    public ResponseEntity<?> Login(@RequestBody LoginRequest person) {

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

    @GetMapping("find/id/{username}")
    public Integer findIdByUsername(@PathVariable String username){
        return personService.findIdByUsername(username);
    }

    @GetMapping("admin/find/users/merchant")
    public List<Person> findUsersAndMerchant(){
        return personService.findUsersAndMerchant();
    }
    @DeleteMapping("admin/delete/account/{id}")
    public void deletePerson(@PathVariable Integer id){
        personService.deletePerson(id);
    }

    @PutMapping("update/account/{id}")
    public Person updatePerson(@PathVariable Integer id,Person person){
        return personService.updatePerson(id,person);
    }

    @GetMapping("find/{id}")
    public Person findById(@PathVariable Integer id){
        return personService.findById(id);
    }




}
