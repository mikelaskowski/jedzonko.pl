package com.java25wro.service.order;

import com.java25wro.model.OrderedMeals;

import java.util.Set;

public interface IOrderService {
    Set<OrderedMeals> findAllMealsByOrderId(Long orderId);
}
