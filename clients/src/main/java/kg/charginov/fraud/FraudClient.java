package kg.charginov.fraud;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "fraud"
)
public interface FraudClient {

    @GetMapping(path = "api/v1/fraud-check/{customerId}")
    ResponseEntity<FraudCheckResponse> isFraudster(
            @PathVariable("customerId") Long customerId);

}
