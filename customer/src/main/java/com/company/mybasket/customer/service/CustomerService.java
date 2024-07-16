package com.company.mybasket.customer.service;

import com.company.mybasket.customer.request.CustomerRegisterRequest;
import org.springframework.stereotype.Service;

public interface CustomerService {
    Integer registerCustomer(CustomerRegisterRequest request);
}
