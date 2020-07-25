package com.java25wro.model;

import com.java25wro.common.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Restaurant extends BaseEntity {

    @Id
    @GeneratedValue
    Long Id;
    @Column( unique = true)
    String restaurantName;
    String restaurantAdress;

    private boolean deleted = false;

    @OneToMany(mappedBy = "restaurant")
    private Set<Meal> meals;

    @Override
    public Long getId() {
        return Id;
    }

    public Restaurant() {
    }

    public Restaurant(String restaurantName, String restaurantAdress) {
        this.restaurantAdress = restaurantAdress;
        this.restaurantName = restaurantName;
    }

    public void setId(Long id) {
        Id = id;
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
        deleted = deleted;
    }
}

