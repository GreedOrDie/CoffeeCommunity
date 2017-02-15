package com.theironyard.Entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by darionmoore on 1/25/17.
 */
@Entity
@Table(name = "coffees")
public class Coffee {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String manufacturer;

    @Column(nullable = false)
    private LocalDateTime submitted = LocalDateTime.now();

    @ManyToMany(mappedBy = "preferredCoffee")
    List<User> userPreferee = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "COFFEE_TAGS", joinColumns = @JoinColumn(name = "COFFEE_ID"),
               inverseJoinColumns = @JoinColumn(name = "TAG_ID"))
    List <Tag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "coffeeId")
    List<Rating> ratings = new ArrayList<>();


    public Coffee() {
    }

    public Coffee(List<Tag> tags) {
        this.tags = tags;
    }

    public Coffee(String name, String description, double price, String manufacturer, LocalDateTime submitted) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.manufacturer = manufacturer;
        this.submitted = submitted;
    }

    public int getId(int id) {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getSubmitted() {
        return submitted;
    }

    public void setSubmitted(LocalDateTime submitted) {
        this.submitted = submitted;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<User> getUserPreferee() {
        return userPreferee;
    }

    public void setUserPreferee(List<User> userPreferee) {
        this.userPreferee = userPreferee;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }


}
