package com.theironyard.Command;

/**
 * Created by darionmoore on 2/8/17.
 */
public class RatingCommand {

    private int id;
    private int rate;
    private int average;
    private int totalRateCounter;
    private int coffeeId;
    private int userId;

    public RatingCommand() {
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

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public int getTotalRateCounter() {
        return totalRateCounter;
    }

    public void setTotalRateCounter(int totalRateCounter) {
        this.totalRateCounter = totalRateCounter;
    }

    public int getCoffeeId() {
        return coffeeId;
    }

    public void setCoffeeId(int coffeeId) {
        this.coffeeId = coffeeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
