package com.java25wro.controller;

import com.java25wro.model.Restaurant;
import com.java25wro.model.RestaurantDTO;
import com.java25wro.service.IRestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

    @Autowired
    private ModelMapper modelMapper;

    private final IRestaurantService restaurantService;

    @Autowired
    public RestaurantController(IRestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping

    public void addRestaurant(@RequestBody Restaurant restaurant) {
      restaurantService.save(restaurant);
    }

    @GetMapping("/restaurant/{name}")
    public RestaurantDTO findByName(@PathVariable Long id){
        Optional<Restaurant> byName = restaurantService.findById(id);
        return byName
                .map(this::convertToDto)
                .orElseThrow(RuntimeException::new);
    }

    @GetMapping
    public Set<RestaurantDTO> getAll(){
        Set<Restaurant> all = restaurantService.findAll();
        return all.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        Restaurant byName = restaurantService.findById(id).orElse(new Restaurant("0","0"));
        restaurantService.delete(byName);
    }

    private RestaurantDTO convertToDto(Restaurant restaurant) {
        return modelMapper.map(restaurant, RestaurantDTO.class);
    }

}
