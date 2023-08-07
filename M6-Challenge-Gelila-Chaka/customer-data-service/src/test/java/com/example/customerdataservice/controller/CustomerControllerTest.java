package com.example.customerdataservice.controller;

import com.example.customerdataservice.controller.CustomerController;
import com.example.customerdataservice.model.Customer;
import com.example.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testCreateCustomer() throws Exception {
        Customer newCustomer = new Customer("John", "Doe", "New York");

        when(customerRepository.save(any(Customer.class))).thenReturn(newCustomer);

        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newCustomer)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName").value("John"));
    }

    @Test
    void testUpdateCustomer() throws Exception {
        Customer updatedCustomer = new Customer("Jane", "Smith", "California");

        mockMvc.perform(put("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedCustomer)))
                .andExpect(status().isNoContent());

        verify(customerRepository, times(1)).save(updatedCustomer);
    }

    @Test
    void testDeleteCustomer() throws Exception {
        mockMvc.perform(delete("/customers/1"))
                .andExpect(status().isNoContent());

        verify(customerRepository, times(1)).deleteById(1);
    }

    @Test
    void testGetCustomerById() throws Exception {
        Customer customer = new Customer("John", "Doe", "New York");
        when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

        mockMvc.perform(get("/customers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("John"));
    }

    @Test
    void testGetCustomersByState() throws Exception {
        when(customerRepository.findByState("New York")).thenReturn(Collections.singletonList(new Customer("John", "Doe", "New York")));

        mockMvc.perform(get("/customers/state/New York"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("John"));
    }
}

