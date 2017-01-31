package com.theironyard.Entities;

import javax.persistence.*;

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

    public Tag() {
    }

    public Tag(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
