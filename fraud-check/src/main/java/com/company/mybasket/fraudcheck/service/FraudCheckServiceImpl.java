package com.company.mybasket.fraudcheck.service;

import com.company.mybasket.fraudcheck.entity.FraudCheckHistory;
import com.company.mybasket.fraudcheck.repository.FraudCheckHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class FraudCheckServiceImpl implements FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
    @Override
    public Boolean checkIfFraud(String customerId) {
        // Assumption: All the customers is not fraud
        FraudCheckHistory fraudCheckHistory = FraudCheckHistory.builder()
                .customerId(Integer.parseInt(customerId))
                .isFraudulent(false)
                .timestamp(LocalDateTime.now())
                .build();

        fraudCheckHistoryRepository.save(fraudCheckHistory);
        return false;
    }
}
