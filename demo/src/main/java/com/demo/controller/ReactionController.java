package com.demo.controller;

import com.demo.model.Reaction;
import com.demo.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ReactionController {

    @Autowired
    private ReactionService reactionService;

    @PostMapping("user/reactions")
    public Reaction addReaction(@RequestBody Reaction reaction){
        return reactionService.addReaction(reaction);
    }

    @GetMapping("/reactions/{id}")
    public List<Reaction> reactionUser(@PathVariable Integer id){
        return reactionService.findReactionUser(id);
    }
    @GetMapping("reactions/meal/{id}")
    public List<Reaction> reactionmeal(@PathVariable Integer id){
        return reactionService.findReactionMeal(id);
    }
    

}
