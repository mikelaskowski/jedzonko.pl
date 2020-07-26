package com.java25wro.controller;

import com.java25wro.model.OrderedMeals;
import com.java25wro.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/order")
public class OrderController {

    private IOrderService orderService;

    @Autowired
    public OrderController(IOrderService orderService){
        this.orderService=orderService;
    }

    @GetMapping(value = "/{order_id}")
    public Set<OrderedMeals> findMealsByOrderId(@PathVariable Long orderId){
        return orderService.findAllMealsByOrderId(orderId);
    }
}
