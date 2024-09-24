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

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@DiscriminatorValue("MERCHANT")
public class Merchant extends Person {

    @OneToMany(mappedBy = "merchant")
    @JsonIgnore
    private List<Restaurant> restaurantList;
    @OneToMany(mappedBy = "merchant")
    @JsonIgnore
    private List<Message> messageList;
}
