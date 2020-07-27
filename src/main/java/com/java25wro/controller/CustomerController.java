package com.java25wro.controller;

import com.java25wro.model.Customer;
import com.java25wro.repository.CustomerRepository;
import com.java25wro.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService service;
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Customer> getCustomers() {
        Iterable<Customer> customers = customerRepository.findAll();
        return customers;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer add(@RequestBody Customer customer) throws IOException, InterruptedException {
        return customerRepository.save(customer);
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
