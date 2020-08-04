package com.java25wro.service;

import com.java25wro.model.Restaurant;

import java.util.Optional;
import java.util.Set;

public interface IRestaurantService {
    void save(Restaurant restaurant);
    void update(Restaurant restaurant);
    void delete(Restaurant restaurant);
    Set<Restaurant> findAll();
    Optional<Restaurant> findByRestaurantName(String name);}
