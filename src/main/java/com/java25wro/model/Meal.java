package com.java25wro.model;

import com.java25wro.common.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Meal extends BaseEntity {

    private String name;
    private BigDecimal price;
    private String description;
    private String imgPath;
    private String details;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "meal")
    Set<OrderedMeals> orderedMeals;

    private boolean isDeleted;

    public Meal() {
    }

    public Meal(String name, BigDecimal price, String description, String imgPath, String details) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imgPath = imgPath;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }


    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurantId(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

}
