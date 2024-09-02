package com.demo.controller;

import com.demo.model.Reaction;
import com.demo.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class ReactionController {

    @Autowired
    private ReactionService reactionService;

    @PostMapping("/reactions")
    public Reaction addReaction(@RequestBody Reaction reaction){
        return reactionService.addReaction(reaction);
    }

}
