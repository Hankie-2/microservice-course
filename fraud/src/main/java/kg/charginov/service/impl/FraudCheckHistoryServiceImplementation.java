package kg.charginov.service.impl;

import kg.charginov.model.entity.FraudCheckHistory;
import kg.charginov.repository.FraudCheckHistoryRepository;
import kg.charginov.service.FraudCheckHistoryService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record FraudCheckHistoryServiceImplementation(
        FraudCheckHistoryRepository fraudCheckHistoryRepository) implements FraudCheckHistoryService {
    @Override
    public boolean isFraudulentCustomer(Long id) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .isFraudster(false)
                        .customerId(id)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
