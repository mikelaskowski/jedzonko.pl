package com.java25wro.service.order;

import com.java25wro.model.OrderedMeals;
import com.java25wro.repository.OrderedMealsRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrderService implements IOrderService{

    private OrderedMealsRepository orderRepository;

    @Override
    public Set<OrderedMeals> findAllMealsByOrderId(Long orderId) {
        return orderRepository.findAllMealsByOrderId(orderId);
    }
}
