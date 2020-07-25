package com.java25wro.repository;

import com.java25wro.model.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {
    @Override
    List<Meal> findAll();

    Set<Meal> findAllByRestaurant_Id(Long id);
}
