package com.java25wro.controller;

import com.java25wro.model.meal.Meal;
import com.java25wro.model.meal.MealDTO;
import com.java25wro.model.restaurant.Restaurant;
import com.java25wro.model.restaurant.RestaurantDTO;
import com.java25wro.service.meal.IMealService;
import com.sun.xml.bind.v2.util.CollisionCheckStack;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/meal")
public class MealController {

    private IMealService mealService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public MealController(IMealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping
    public List<MealDTO> findAll() {
        List<Meal> all= mealService.findAll();
        return all.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping(value = "/restaurant/{restaurantId}")
    public Set<MealDTO> findMealsByRestaurantId(@PathVariable Long id) {
        Set<Meal> mealsByRestaurantId = mealService.findMealsByRestaurantId(id);
        return mealsByRestaurantId.stream()
                .map(this::convertToDto)
                .collect(Collectors.toSet());
    }

    @GetMapping(value = "/{mealId}")
    public MealDTO findMealByMealId(@PathVariable Long mealId){
        Meal mealByMealId = mealService.findMealByMealId(mealId);
        return convertToDto(mealByMealId);
    }

    @PostMapping
    public Meal createMeal(@RequestBody Meal newMeal){
        mealService.createMeal(newMeal);
        return newMeal;
    }

    @DeleteMapping(value = "/{mealId}")
    public String deleteMeal(@PathVariable Long mealId){
        mealService.deleteMeal(mealId);
        return "Delete meal with";
    }

    private MealDTO convertToDto(Meal meal) {
        return modelMapper.map(meal, MealDTO.class);
    }

}
