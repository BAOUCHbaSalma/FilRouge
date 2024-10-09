package com.demo.service;

import com.demo.dto.ReactionDto;
import com.demo.mapper.ReactionMapper;
import com.demo.model.Meal;
import com.demo.model.Reaction;
import com.demo.model.User;
import com.demo.repository.MealRepository;
import com.demo.repository.ReactionRepository;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReactionService {
    @Autowired
    private ReactionRepository reactionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MealRepository mealRepository;
    public Reaction addReaction(ReactionDto dto){
        Meal meal=mealRepository.findById(dto.getMealId()).orElseThrow();
        User user=userRepository.findById(dto.getUserId()).orElseThrow();
        Reaction reaction= ReactionMapper.toEntity(dto,user,meal);
        return reactionRepository.save(reaction);
    }
    public List<Reaction> findAll(){
        return reactionRepository.findAll();
    }
    public List<Reaction> findReactionMeal(Integer id){
            return reactionRepository.findAllByMeal_Id(id);
    }
    public List<Reaction> findReactionUser(Integer id){
        return reactionRepository.findAllByUser_Id(id);
    }

    public Integer likesavg(Integer id){
        return reactionRepository.moyenneReaction(id);
    }
    public void deleteReaction(Integer id){
        reactionRepository.deleteById(id);
    }
}