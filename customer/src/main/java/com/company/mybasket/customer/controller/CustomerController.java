package com.company.mybasket.customer.controller;

import com.company.mybasket.client.response.SuccessResponse;
import com.company.mybasket.customer.request.CustomerRegisterRequest;
import com.company.mybasket.customer.service.CustomerService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RequestMapping(path = "api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;
    int count = 1;

    // @CircuitBreaker(name = "registerCustomerR4J", fallbackMethod = "registerCustomerFallback")
    // @Retry(name = "registerCustomerR4J", fallbackMethod = "registerCustomerFallback")
    @RateLimiter(name = "registerCustomerR4J", fallbackMethod = "registerCustomerFallback")
    @PostMapping(path = "")
    public SuccessResponse registerCustomer(@RequestBody CustomerRegisterRequest request) {
        System.out.println(count++);
        Integer id = customerService.registerCustomer(request);
        return SuccessResponse.builder()
                .message("Customer registered")
                .status(HttpStatus.CREATED)
                .data(id)
                .timestamp(LocalDateTime.now())
                .build();
    }

    public SuccessResponse registerCustomerFallback(CustomerRegisterRequest request, Exception exception) {
        System.out.println(exception.getMessage());
        return SuccessResponse.builder()
                .message("Certain services are not working")
                .status(HttpStatus.CREATED)
                .data(exception.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

}
