package com.example.demo.service;

import com.example.demo.exception.CustomerAlreadyExistsException;
import com.example.demo.exception.NoSuchCustomerExistsException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl  implements  CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomer(Long id)
    {
        return customerRepository.findById(id).orElseThrow(
                ()->new NoSuchCustomerExistsException("NO CUSTOMER PRESENT WITH ID = " + id)
        );
    }

    public  String addCustomer(Customer customer)
    {
        Customer existingCustomer
                = customerRepository.findById(customer.getId())
                .orElse(null);

        if(existingCustomer ==null)
        {
            customerRepository.save(customer);
            return "Customer added successfully";
        }
        else
            throw  new CustomerAlreadyExistsException("Customer already exist!!");
    }
    public String updateCustomer(Customer customer)
    {
        Customer existingCustomer
                = customerRepository.findById((customer.getId()))
                .orElse(null);
        if(existingCustomer==null)
            throw  new NoSuchCustomerExistsException("No Such Customer exist!!");
        else
        {
            existingCustomer.setName(customer.getName());
            existingCustomer.setAddress(customer.getAddress());
            customerRepository.save(existingCustomer);
            return "Record updated Successfully";
        }
    }

}
