package com.java25wro.service.meal;

import com.java25wro.model.OrderedMeals;
import com.java25wro.repository.OrderedMealsRepository;
import com.java25wro.service.meal.IOrderedMealsService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrderedMealsService implements IOrderedMealsService {

    private OrderedMealsRepository orderedMealsRepository;

    @Override
    public Set<OrderedMeals> findAllMealsByOrderId(Long orderId) {
        return orderedMealsRepository.findAllMealsByOrderId(orderId);
    }
}
