package com.servbyte.app.services;

import com.servbyte.app.entities.Customer;
import com.servbyte.app.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer create(Customer customer) {
        return this.customerRepository.save(customer);
    }

    public List<Customer> getAll() {
        return this.customerRepository.findAll();
    }
}
