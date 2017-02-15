package com.theironyard.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by darionmoore on 1/25/17.
 */
@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String description;


    @ManyToMany(mappedBy = "tags")
    List<Coffee> coffeeList = new ArrayList<>();


    public Tag() {
    }

    public Tag(String description) {
        this.description = description;
    }

    public Tag(String description, List<Coffee> coffeeList) {
        this.description = description;
        this.coffeeList = coffeeList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Coffee> getCoffeeList() {
        return coffeeList;
    }

    public void setCoffeeList(List<Coffee> coffeeList) {
        this.coffeeList = coffeeList;
    }
}
