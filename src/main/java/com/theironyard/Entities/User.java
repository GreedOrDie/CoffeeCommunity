package com.theironyard.Entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by darionmoore on 1/25/17.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean isActive;

    @ManyToMany
    @JoinTable(name = "USER_PREFERENCES", joinColumns = @JoinColumn(name = "USER_ID"),
               inverseJoinColumns = @JoinColumn(name = "COFFEE_ID"))
    List<Coffee> preferredCoffee = new ArrayList<>();

    @OneToMany(mappedBy = "userId")
    List<Rating> rate = new ArrayList<>();


    public User() {
    }

    public User(List<Coffee> preferredCoffee) {
        this.preferredCoffee = preferredCoffee;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String name, String email, String phone, String username, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public User(String name, String email, String phone, String username, String password, boolean isActive) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
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

    public List<Coffee> getPreferredCoffee() {
        return preferredCoffee;
    }

    public void setPreferredCoffee(List<Coffee> preferredCoffee) {
        this.preferredCoffee = preferredCoffee;
    }

    public List<Rating> getRate() {
        return rate;
    }

    public void setRate(List<Rating> rate) {
        this.rate = rate;
    }
}


