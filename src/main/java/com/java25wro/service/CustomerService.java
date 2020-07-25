package com.java25wro.service;

import com.java25wro.model.Customer;
import com.java25wro.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public void deleteById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        customerRepository.delete(customer);
    }
}
