package com.demo.mapper;

import com.demo.dto.ReactionDto;
import com.demo.model.Meal;
import com.demo.model.Reaction;
import com.demo.model.User;
import org.mapstruct.*;

public class ReactionMapper {

    public static Reaction toEntity(ReactionDto dto, User user, Meal meal) {
        Reaction reaction = new Reaction();
        reaction.setLikes(dto.getLikes());
        reaction.setComment(dto.getComment());
        reaction.setUser(user);
        reaction.setMeal(meal);
        return reaction;
    }

    public static ReactionDto toDto(Reaction reaction) {
        ReactionDto dto = new ReactionDto();
        dto.setLikes(reaction.getLikes());
        dto.setComment(reaction.getComment());
        dto.setUserId(reaction.getUser().getId());
        dto.setMealId(reaction.getMeal().getId());
        return dto;
    }
}