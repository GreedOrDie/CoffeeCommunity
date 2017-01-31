package com.theironyard.Entities;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by darionmoore on 1/25/17.
 */
@Entity
@Table(name = "varieties")
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

    @ManyToOne
    Tag tag;

    public Coffee() {
    }

    public Coffee(String name, String description, double price, String manufacturer, LocalDateTime submitted) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.manufacturer = manufacturer;
        this.submitted = submitted;
    }

    public Coffee(String name, String description, double price, String manufacturer, LocalDateTime submitted, Tag tag) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.manufacturer = manufacturer;
        this.submitted = submitted;
        this.tag = tag;
    }

    public int getId() {
        return id;
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

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

}
