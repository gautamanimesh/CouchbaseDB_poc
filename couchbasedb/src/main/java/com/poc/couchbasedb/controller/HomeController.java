package com.poc.couchbasedb.controller;


import com.poc.couchbasedb.model.Customer;
import com.poc.couchbasedb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/customer/save")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveCustomer(@RequestBody Customer customer) {
        Optional<Customer> c1 = customerRepository.findById(customer.getId());
        if (!c1.isPresent()) {
            customerRepository.save(customer);
            return "Customer Saved Successfully!";
        } else {
            throw new IllegalArgumentException("Customer already exists with id: " + customer.getId());
        }
    }

    @GetMapping("/fetchAllCustomers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping("customer/delete/{id}")
    public String deleteCustomerById(@PathVariable("id") int id) {
        Optional<Customer> c1 = customerRepository.findById(id);
        if (c1.isPresent()) {
            customerRepository.deleteById(id);
            return "Customer Deleted Successfully";
        } else {
            throw new IllegalArgumentException("Cannot delete non-existent Customer!");
        }
    }

    @PostMapping("/customer/update")
    public String updateCustomer (@RequestBody Customer customer) {
        Optional<Customer> c1 = customerRepository.findById(customer.getId());
        if (c1.isPresent()) {
            Customer newCustomer = c1.get();
            newCustomer.setId(customer.getId());
            newCustomer.setName(customer.getName());
            newCustomer.setAddress(customer.getAddress());
            customerRepository.save(newCustomer);
            return "Customer Updated Successfully";
        } else {
            customerRepository.save(customer);
            return "Customer Saved Successfully";
        }
    }
}
