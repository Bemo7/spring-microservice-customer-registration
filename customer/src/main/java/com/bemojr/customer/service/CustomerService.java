package com.bemojr.customer.service;

import com.bemojr.customer.dto.CustomerRegistrationRequest;
import com.bemojr.customer.model.Customer;
import com.bemojr.customer.repo.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.save(customer);
    }
}
