package com.example.demo.service;

import com.example.demo.model.Customer;

public interface CustomerService {

    Customer getCustomer(Long id);
    String addCustomer(Customer customer);
    String updateCustomer(Customer customer);
}
