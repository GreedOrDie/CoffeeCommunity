package com.theironyard.Command;

import com.theironyard.Entities.Tag;
import com.theironyard.Entities.User;

import java.time.LocalDateTime;

/**
 * Created by darionmoore on 1/26/17.
 */
public class CoffeeCommand {
    private int id;
    private String name;
    private String description;
    private double price;
    private String manufacturer;
    private LocalDateTime submitted = LocalDateTime.now();
    private Tag tag;
    private User preferred;


    public CoffeeCommand() {
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

    public Tag getTag(Tag newTag) {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public User getPreferred() {
        return preferred;
    }

    public void setPreferred(User preferred) {
        this.preferred = preferred;
    }
}
