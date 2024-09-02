package com.demo.service;

import com.demo.model.Reaction;
import com.demo.repository.ReactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactionService {

    @Autowired
    private ReactionRepository reactionRepository;

    public Reaction addReaction(Reaction reaction){
        return reactionRepository.save(reaction);
    }


    public List<Reaction> findAll(){
        return reactionRepository.findAll();
    }

    public List<Reaction> findReactionMeal(Integer id){
            return reactionRepository.findAllByMeal_Id(id);
    }
}
