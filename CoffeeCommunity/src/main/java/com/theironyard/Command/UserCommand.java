package com.theironyard.Command;

import com.theironyard.Entities.Coffee;
import com.theironyard.Entities.Rating;
import com.theironyard.Entities.User;

/**
 * Created by darionmoore on 1/26/17.
 */
public class UserCommand {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String username;
    private String password;
    private boolean isActive;
    private Coffee preference;
    private Rating rate;

    public UserCommand() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public User setActive(boolean active) {
        isActive = active;
        return null;
    }

    public Coffee getPreference() {
        return preference;
    }

    public void setPreference(Coffee preference) {
        this.preference = preference;
    }

    public Rating getRate() {
        return rate;
    }

    public void setRate(Rating rate) {
        this.rate = rate;
    }
}
