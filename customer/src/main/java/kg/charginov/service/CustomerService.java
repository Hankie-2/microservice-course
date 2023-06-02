package kg.charginov.service;

import kg.charginov.model.entity.Customer;
import kg.charginov.model.request.CustomerRegistrationRequest;

public interface CustomerService {
    public Customer registerCustomer(CustomerRegistrationRequest request);
}
