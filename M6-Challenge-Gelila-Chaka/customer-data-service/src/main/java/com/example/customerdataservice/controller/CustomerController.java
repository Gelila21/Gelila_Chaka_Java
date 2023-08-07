package com.example.customerdataservice.controller;

import com.example.customerdataservice.model.Customer;
import com.example.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {


    @Autowired
     CustomerRepository repo;


    // POST route to create a new customer
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer) {
        return repo.save(customer);
    }

    // PUT route to update an existing customer
    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer) {
        repo.save(customer);
    }
    // DELETE route to delete an existing customer
    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int customerId) {
        repo.deleteById(customerId);
    }

    // GET route to return a specific customer by id
    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable int customerId) {
        Optional<Customer> customerOptional = repo.findById(customerId);

        if (customerOptional.isPresent()) {
            return customerOptional.get();
        } else {
            return null;
        }
    }

    // GET route to return all customers for a specific state
    @GetMapping("/state/{state}")
    public List<Customer> getCustomersByState(@PathVariable String state) {
        return repo.findByState(state);
    }

}
