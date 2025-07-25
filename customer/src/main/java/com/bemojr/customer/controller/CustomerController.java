package com.bemojr.customer.controller;

import com.bemojr.customer.dto.CustomerRegistrationRequest;
import com.bemojr.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public record CustomerController(CustomerService customerService){

    @PostMapping("")
    public ResponseEntity<?> registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        customerService.registerCustomer(customerRegistrationRequest);
        log.info("new customer registration {}", customerRegistrationRequest);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
};
