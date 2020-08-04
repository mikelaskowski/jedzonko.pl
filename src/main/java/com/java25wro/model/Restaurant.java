package com.java25wro.model;

import com.java25wro.common.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Restaurant extends BaseEntity {


    @Column( unique = true)
    String restaurantName;
    String restaurantAdress;
    String email;

    private boolean deleted = false;

    @OneToMany(mappedBy = "restaurant")
    private Set<Meal> meals = new HashSet<>();

    public Restaurant() {
    }

    public Restaurant(String restaurantName, String restaurantAdress) {
        this.restaurantAdress = restaurantAdress;
        this.restaurantName = restaurantName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAdress() {
        return restaurantAdress;
    }

    public void setRestaurantAdress(String restaurantAdress) {
        this.restaurantAdress = restaurantAdress;
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

