package com.demo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@DiscriminatorValue("USER")
public class User extends Person{
}
