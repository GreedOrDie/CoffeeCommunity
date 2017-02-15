package com.theironyard.Command;

import com.theironyard.Entities.Coffee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darionmoore on 1/26/17.
 */
public class TagCommand {
    private String description;
    private List<Coffee> coffeeList = new ArrayList<>();

    public TagCommand() {
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
