package com.java25wro.controller;

import com.java25wro.model.Restaurant;
import com.java25wro.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {
    private final IRestaurantService restaurantService;
    @Autowired
    public RestaurantController(IRestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    @PostMapping("(restaurant)")
    public void addRestaurant(@RequestBody Restaurant restaurant){
        this.restaurantService.save(restaurant);
    }
    @GetMapping("/restaurant/{name}")
    public Optional<Restaurant> findByName(@PathVariable String name){
        return restaurantService.findByName(name);
    }
    @GetMapping
    public Set<Restaurant> getAll(){
        return restaurantService.findAll();
    }
    @DeleteMapping("/(name)")
    public void delete(@PathVariable String name){
        Restaurant byName = restaurantService.findByName(name).orElse(new Restaurant("0","0"));
        restaurantService.delete(byName);
    }

}
