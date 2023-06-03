package kg.charginov.service.impl;

import kg.charginov.config.CustomerConfig;
import kg.charginov.model.entity.Customer;
import kg.charginov.model.fraud.response.FraudCheckResponse;
import kg.charginov.model.request.CustomerRegistrationRequest;
import kg.charginov.repository.CustomerRepository;
import kg.charginov.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public record CustomerServiceImpl(
        CustomerRepository customerRepository,
        RestTemplate restTemplate) implements CustomerService {


    @Override
    public Customer registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .email(request.email())
                .lastName(request.lastName())
                .build();
        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("Fraudster");
        }

        return customer;
    }
}
