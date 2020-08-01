package com.java25wro.controller;

import com.java25wro.service.emails.EmailService;
import com.java25wro.model.Order;
import com.java25wro.model.OrderedMeals;
import com.java25wro.repository.OrderRepository;
import com.java25wro.service.meal.IOrderedMealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Set;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private IOrderedMealsService orderService;
    private OrderRepository orderRepository;
    private EmailService emailService;

    @Autowired
    public OrderController(IOrderedMealsService orderService, OrderRepository orderRepository, EmailService emailService){
        this.orderService=orderService;
        this.orderRepository=orderRepository;
        this.emailService=emailService;
    }


    @GetMapping(value = "/{order_id}")
    public Set<OrderedMeals> findMealsByOrderId(@PathVariable Long orderId){
        return orderService.findAllMealsByOrderId(orderId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order) throws IOException, InterruptedException {
        orderRepository.save(order);
        emailService.sendOrderConfirmationEmail(order);
        return order;
        //todo Customer Id
    }
}
