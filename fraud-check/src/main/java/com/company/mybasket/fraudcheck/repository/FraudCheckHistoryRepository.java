package com.company.mybasket.fraudcheck.repository;

import com.company.mybasket.fraudcheck.entity.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {

}