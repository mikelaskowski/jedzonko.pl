package com.java25wro.model;

import com.java25wro.common.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @OneToMany(mappedBy = "order")
    private Set<OrderedMeals> orderedMeals;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private boolean isEmpty;

    public Order() {
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
