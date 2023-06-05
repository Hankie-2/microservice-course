package kg.charginov.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        value = "fraud",
        path = "api/v1/fraud-check"
)
public interface FraudClient {

    @GetMapping(path = "{customerId}")
    ResponseEntity<FraudCheckResponse> isFraudster(
            @PathVariable("customerId") Long customerId);

}
