package com.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "meal")
    @JsonIgnore
    private List<OrderUser> orderList;

    @OneToMany(mappedBy = "meal")
    @JsonIgnore
    private List<Reaction> reactionList;

}
