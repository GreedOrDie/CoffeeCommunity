package com.theironyard.Entities;

import javax.persistence.*;

/**
 * Created by darionmoore on 2/7/17.
 */
@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private int rate;

    @ManyToOne
    Coffee coffeeId;

    @ManyToOne
    User userId;

    public Rating() {
    }

    public Rating(int rate) {
        this.rate = rate;
    }

    public Rating(int rate, Coffee coffeeId, User userId) {
        this.rate = rate;
        this.coffeeId = coffeeId;
        this.userId = userId;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Coffee getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(Coffee coffeeId) {
        this.coffeeId = coffeeId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
