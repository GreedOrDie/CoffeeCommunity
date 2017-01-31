package com.theironyard.Command;

import java.time.LocalDateTime;

/**
 * Created by darionmoore on 1/26/17.
 */
public class CoffeeCommand {

    private String name;
    private String description;
    private double price;
    private String manufacturer;
    private LocalDateTime submitted = LocalDateTime.now();
    private boolean preference;

    public CoffeeCommand() {
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

    public boolean isPreference() {
        return preference;
    }

    public void setPreference(boolean preference) {
        this.preference = preference;
    }
}
