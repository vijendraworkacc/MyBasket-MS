package com.company.mybasket.client.fraudcheck;

import com.company.mybasket.client.response.SuccessResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "fraud-check-application",
        path = "api/v1/fraud-check"
)
public interface FraudCheckClient {
    @GetMapping(path = "")
    public SuccessResponse checkIfFraud(@RequestParam(name = "customer_id") String customerId);
}
