package com.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRestaurant;
    @Column
    private String name;
    @Column
    private String ville;
    @Column
    private double latitude;
    @Column
    private double longitude;

    @ManyToOne
    @JoinColumn(name = "idMerchant")
    private Merchant merchant;

    @OneToMany(mappedBy = "restaurant")
    @JsonIgnore
    private List<Meal> mealList;

}
