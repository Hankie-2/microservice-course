package kg.charginov.service.impl;

import kg.charginov.fraud.FraudCheckResponse;
import kg.charginov.fraud.FraudClient;
import kg.charginov.model.entity.Customer;
import kg.charginov.model.request.CustomerRegistrationRequest;
import kg.charginov.repository.CustomerRepository;
import kg.charginov.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;

    @Override
    public Customer registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .email(request.email())
                .lastName(request.lastName())
                .build();

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId()).getBody();

        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("Fraudster");
        }

        return customer;
    }
}
