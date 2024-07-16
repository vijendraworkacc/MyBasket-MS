package com.company.mybasket.fraudcheck.controller;

import com.company.mybasket.client.response.SuccessResponse;
import com.company.mybasket.fraudcheck.service.FraudCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RequestMapping(path = "api/v1/fraud-check")
@RestController
public class FraudCheckController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "")
    public SuccessResponse checkIfFraud(@RequestParam(name = "customer_id") String customerId) {
        Boolean isFraud = fraudCheckService.checkIfFraud(customerId);
        return SuccessResponse.builder()
                .message("Customer is checked")
                .status(HttpStatus.OK)
                .data(isFraud)
                .timestamp(LocalDateTime.now())
                .build();
    }
}
