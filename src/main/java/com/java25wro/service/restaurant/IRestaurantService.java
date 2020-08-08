package com.java25wro.service.restaurant;

import com.java25wro.model.restaurant.Restaurant;

import java.util.Optional;
import java.util.Set;

public interface IRestaurantService {
    void save(Restaurant restaurant);
    void update(Restaurant restaurant);
    void delete(Restaurant restaurant);
    Set<Restaurant> findAll();
    Optional<Restaurant> findById(Long id);}
