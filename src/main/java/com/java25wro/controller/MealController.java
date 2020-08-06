package com.java25wro.controller;

import com.java25wro.model.Meal;
import com.java25wro.service.meal.IMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping(value = "/meal")
public class MealController {

    private IMealService mealService;

    @Autowired
    public MealController(IMealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping(value = "")
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

    @PostMapping(value = "")
    public Meal createMeal(@RequestBody Meal newMeal){
        mealService.createMeal(newMeal);
        return newMeal;
    }

    @DeleteMapping(value = "/{mealId}")
    public String deleteMeal(@PathVariable Long mealId){
        mealService.deleteMeal(mealId);
        return "Delete meal with";
    }

}
