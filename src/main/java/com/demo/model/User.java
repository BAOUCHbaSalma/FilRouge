package com.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@DiscriminatorValue("USER")
public class User extends Person{
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Message> messageList;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<OrderUser> orderList;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Reaction> reactionList;
}
