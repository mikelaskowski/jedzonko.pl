package com.java25wro.service;

import com.java25wro.exceptions.UserDoesntExistException;
import com.java25wro.model.Customer;
import com.java25wro.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public void deleteById(Long id) {
        Customer customer = findById(id);
        customerRepository.delete(customer);
    }

    public Customer findById(Long id){
        return customerRepository.findById(id).orElseThrow(UserDoesntExistException::new);
        //todo add search when flag isDeleted=false
    }
}
