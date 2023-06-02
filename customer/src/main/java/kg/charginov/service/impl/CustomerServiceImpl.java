package kg.charginov.service.impl;

import kg.charginov.model.entity.Customer;
import kg.charginov.model.request.CustomerRegistrationRequest;
import kg.charginov.repository.CustomerRepository;
import kg.charginov.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public record CustomerServiceImpl(
        CustomerRepository customerRepository
) implements CustomerService {
    @Override
    public Customer registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .email(request.email())
                .lastName(request.lastName())
                .build();
        return customerRepository.save(customer);
    }
}
