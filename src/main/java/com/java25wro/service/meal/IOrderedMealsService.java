package com.java25wro.service.meal;

import com.java25wro.model.OrderedMeals;

import java.util.Set;

public interface IOrderedMealsService {
    Set<OrderedMeals> findAllMealsByOrderId(Long orderId);
}
