package com.java25wro.service;

import com.java25wro.model.Restaurant;
import com.java25wro.repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class RestaurantService implements IRestaurantService {
    private final IRestaurantRepository repository;

    @Autowired
    public RestaurantService(IRestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Restaurant restaurant) {
        repository.save(restaurant);
    }

    @Override
    public void update(Restaurant restaurant) {
    }

    @Override
    public void delete(Restaurant restaurant) {
        restaurant.setDeleted(true);
    }

    @Override
    public Set<Restaurant> findAll() {
        return repository.findAllByDeletedFalse();
    }

    @Override
    public Optional<Restaurant> findByRestaurantName(String name) {
        return repository.findByRestaurantName(name);
    }
}

