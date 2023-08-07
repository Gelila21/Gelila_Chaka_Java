package com.example.customerdataservice.repository;

import com.example.customerdataservice.model.Customer;
import com.example.customerdataservice.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() {
        customerRepository.deleteAll();

        Customer customer1 = new Customer("John", "Doe", "New York");
        Customer customer2 = new Customer("Jane", "Smith", "California");

        customerRepository.save(customer1);
        customerRepository.save(customer2);
    }

    @Test
    public void testFindByState() {
        List<Customer> customersInNewYork = customerRepository.findByState("New York");
        assertEquals(1, customersInNewYork.size());
        assertEquals("John", customersInNewYork.get(0).getFirst_name());
    }

    @Test
    public void testFindByStateNotFound() {
        List<Customer> customersInTexas = customerRepository.findByState("Texas");
        assertEquals(0, customersInTexas.size());
    }
}
