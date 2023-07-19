package com.gabrielmttl.customer.service;


import com.gabrielmttl.customer.dto.CustomerRegistrationRequest;
import com.gabrielmttl.customer.entity.Customer;
import com.gabrielmttl.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;


@Service
public record CustomerService(CustomerRepository customerRepository) {
    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
        // TODO: check email valid
        // TODO: check email not taken
        customerRepository.save(customer);
    }
}
