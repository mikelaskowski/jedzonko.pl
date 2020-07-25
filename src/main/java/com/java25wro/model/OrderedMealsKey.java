package com.java25wro.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderedMealsKey implements Serializable {
    @Column(name = "order_id")
    Long orderId;

    @Column(name = "meal_id")
    Long mealId;

    public OrderedMealsKey() {
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    //equals
    //hashcode
}
