package com.company.mybasket.customer.service;

import com.company.mybasket.client.fraudcheck.FraudCheckClient;
import com.company.mybasket.client.notification.NotificationClient;
import com.company.mybasket.client.response.SuccessResponse;
import com.company.mybasket.customer.entity.Customer;
import com.company.mybasket.customer.repository.CustomerRepository;
import com.company.mybasket.customer.request.CustomerRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudCheckClient fraudCheckClient;
    private final NotificationClient notificationClient;

    @Override
    public Integer registerCustomer(CustomerRegisterRequest request) {
        Customer customer = Customer.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .build();
        Integer id = customerRepository.save(customer).getId();
        // SuccessResponse successResponse = restTemplate.getForObject("http://FRAUD-CHECK-APPLICATION/api/v1/fraud-check?customer_id={id}", SuccessResponse.class, id);
        SuccessResponse successResponse = fraudCheckClient.checkIfFraud(String.valueOf(id));
        if ((Boolean) successResponse.getData()) {
            throw new RuntimeException("Customer is fraudulent");
        }
        SuccessResponse successResponse_ = notificationClient.sendEmail("mybasket-support@mybasket.com", customer.getEmail());
        System.out.println(successResponse_.getData());
        return id;
    }
}
