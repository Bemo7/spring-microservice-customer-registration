package com.bemojr.fraud.controller;

import com.bemojr.fraud.dto.FraudCheckResponse;
import com.bemojr.fraud.service.FraudCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/fraud-check")
@Slf4j
public class FraudController {
    public final FraudCheckService fraudCheckService;

    @GetMapping("{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerID) {
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerID);
        log.info("Fraud check for customer {}", customerID);
        return FraudCheckResponse.builder()
                .isFraudster(isFraudulentCustomer)
                .build();
    }
}
