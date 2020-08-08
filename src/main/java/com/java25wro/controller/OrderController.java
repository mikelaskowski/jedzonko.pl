package com.java25wro.controller;

import com.java25wro.service.emails.EmailService;
import com.java25wro.model.Order;
import com.java25wro.model.OrderedMeals;
import com.java25wro.repository.OrderRepository;
import com.java25wro.service.meal.IOrderedMealsService;
import com.java25wro.service.order.OrderService;
import com.java25wro.utilities.GoogleDriveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Set;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/order")
public class OrderController {

    private OrderService orderService;
    private IOrderedMealsService orderedMealsService;
    private OrderRepository orderRepository;
    private EmailService emailService;
    private GoogleDriveService googleDriveService;

    @Autowired
    public OrderController(OrderService orderService, IOrderedMealsService orderedMealsService, OrderRepository orderRepository, EmailService emailService, GoogleDriveService googleDriveService){
        this.orderService=orderService;
        this.orderedMealsService=orderedMealsService;
        this.orderRepository=orderRepository;
        this.emailService=emailService;
        this.googleDriveService=googleDriveService;
    }


    @GetMapping(value = "/{order_id}")
    public Set<OrderedMeals> findMealsByOrderId(@PathVariable Long orderId){
        return orderedMealsService.findAllMealsByOrderId(orderId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order) throws Exception {
        orderRepository.save(order);
        orderService.saveOrderToGoogleDrive(order);
        emailService.sendOrderConfirmationEmail(order);
        return order;
        //todo Customer and MEal as ID not object in the JSON request body
    }
}
