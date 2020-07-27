package com.java25wro.model;

import com.java25wro.common.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Restaurant extends BaseEntity {


    @Column( unique = true)
    String name;
    String address;
    String email;

    private boolean deleted = false;

    @OneToMany(mappedBy = "restaurant")
    private Set<Meal> meals = new HashSet<>();

    public Restaurant() {
    }

    public Restaurant(String restaurantName, String address) {
        this.address = address;
        this.name = restaurantName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean deleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }


    public Set<Meal> getMeals() {
        return meals;
    }
}

