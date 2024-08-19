package com.demo.controller;

import com.demo.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;
}
