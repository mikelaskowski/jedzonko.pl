package com.java25wro.controller;

import com.java25wro.model.Meal;
import com.java25wro.service.meal.IMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/meal")
public class MealController {

    private IMealService mealService;

    @Autowired
    public MealController(IMealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping
    public List<Meal> findAll() {
        return mealService.findAll();
    }

    @GetMapping(value = "/restaurant/{restaurantId}")
    public Set<Meal> findMealsByRestaurantId(@PathVariable Long restaurantId) {
        return mealService.findMealsByRestaurantId(restaurantId);
    }

    @GetMapping(value = "/{mealId}")
    public Meal findMealByMealId(@PathVariable Long mealId){
        return mealService.findMealByMealId(mealId);
    }

    @PostMapping
    public Meal createMeal(@RequestBody Meal newMeal){
        mealService.createMeal(newMeal);
        return newMeal;
    }

    @DeleteMapping(value = "/{mealId}")
    public void deleteMeal(@PathVariable Long mealId){
        mealService.deleteMeal(mealId);
    }

}
