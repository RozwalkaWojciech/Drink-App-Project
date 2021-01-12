package com.javer.drink.app.project.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredients")
@Data
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( length = 100)
    private String name;

    private String measure;

//    @ManyToMany(mappedBy = "ingredientList")
//    private List<Drink> drinkList = new ArrayList<>();
}
