package kg.charginov.controller;

import kg.charginov.model.FraudCheckResponse;
import kg.charginov.service.FraudCheckHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudCheckHistoryController {

    private final FraudCheckHistoryService fraudCheckHistoryService;

    @GetMapping(path = "{customerId}")
    public ResponseEntity<?> isFraudster(
            @PathVariable("customerId") Long customerId){
        boolean isFraudulentCustomer = fraudCheckHistoryService
                .isFraudulentCustomer(customerId);
        return new ResponseEntity<>(new FraudCheckResponse(isFraudulentCustomer), HttpStatus.OK);
    }

}
