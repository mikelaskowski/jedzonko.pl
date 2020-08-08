package com.java25wro.model;

import com.java25wro.model.meal.Meal;

import javax.persistence.*;

@Entity
public class OrderedMeals {
    @EmbeddedId
    OrderedMealsKey id;

    @ManyToOne
    @MapsId("order_id")
    @JoinColumn(name = "order_id")
    Order order;

    @ManyToOne
    @MapsId("meal_id")
    @JoinColumn(name = "meal_id")
    Meal meal;

    int numberOfTheSameMeals;

    public OrderedMeals() {
    }

    public OrderedMeals(Order order, Meal meal, int numberOfTheSameMeals) {
        this.order = order;
        this.meal = meal;
        this.numberOfTheSameMeals = numberOfTheSameMeals;
    }

    public OrderedMealsKey getId() {
        return id;
    }

    public void setId(OrderedMealsKey id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public int getNumberOfTheSameMeals() {
        return numberOfTheSameMeals;
    }

    public void setNumberOfTheSameMeals(int numberOfTheSameMeals) {
        this.numberOfTheSameMeals = numberOfTheSameMeals;
    }
}
