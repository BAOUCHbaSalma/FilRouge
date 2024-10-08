package com.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String picture;
    @Column
    private Integer price;
    @Enumerated(EnumType.STRING)
    private EAvailability availability;
    @Column
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "meal")
    @JsonIgnore
    private List<OrderUser> orderList;

    @OneToMany(mappedBy = "meal")
    @JsonManagedReference
    private List<Reaction> reactionList;

    public Meal(String name, String picture, Integer price, Integer quantity) {
        this.name = name;
        this.picture = picture;
        this.price = price;
        this.quantity = quantity;

    }
}
