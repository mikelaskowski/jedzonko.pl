package com.java25wro.model;

import com.java25wro.common.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Order extends BaseEntity {
    private Long restuarantId;
    private Long mealId;
    @OneToMany(mappedBy = "order")
    Set<OrderedMeals> orderedMeals;

    private boolean isEmpty;

    public Order() {
    }

    public Long getRestuarantId() {
        return restuarantId;
    }

    public void setRestuarantId(Long restuarantId) {
        this.restuarantId = restuarantId;
    }

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public Set<OrderedMeals> getOrderedMeals() {
        return orderedMeals;
    }

    public void setOrderedMeals(Set<OrderedMeals> orderedMeals) {
        this.orderedMeals = orderedMeals;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
