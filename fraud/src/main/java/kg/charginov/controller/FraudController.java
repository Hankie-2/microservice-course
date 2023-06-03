package kg.charginov.controller;

import kg.charginov.model.response.FraudCheckResponse;
import kg.charginov.service.FraudCheckHistoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping(path = "{customerId}")
    public ResponseEntity<?> isFraudster(
            @PathVariable("customerId") Long customerId){
        boolean isFraudulentCustomer = fraudCheckHistoryService
                .isFraudulentCustomer(customerId);
        log.info("Fraud check request for customer {}",customerId);
        return new ResponseEntity<>(new FraudCheckResponse(isFraudulentCustomer), HttpStatus.OK);
    }

}
