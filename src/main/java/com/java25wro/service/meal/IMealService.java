package com.java25wro.service.meal;

import com.java25wro.model.meal.Meal;

import java.util.List;
import java.util.Set;

public interface IMealService {

    List<Meal> findAll();

    Set<Meal> findMealsByRestaurantId(Long restaurantId);

    Meal findMealByMealId(Long mealId);

    void createMeal(Meal newMeal);

    void deleteMeal(Long mealId);
}
