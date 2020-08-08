package com.java25wro.repository;

import com.java25wro.model.restaurant.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface IRestaurantRepository extends CrudRepository<Restaurant, Long> {

    Set<Restaurant> findAllByDeletedFalse();
    Optional<Restaurant> findByRestaurantId(Long id);
}

