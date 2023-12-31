package com.gabrielmttl.customer.service;


import com.gabrielmttl.amqp.RabbitMQMessageProducer;
import com.gabrielmttl.clients.fraud.FraudClient;
import com.gabrielmttl.clients.fraud.dto.FraudCheckResponse;
import com.gabrielmttl.clients.notification.NotificationRequest;
import com.gabrielmttl.customer.dto.CustomerRegistrationRequest;
import com.gabrielmttl.customer.entity.Customer;
import com.gabrielmttl.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository,
                              FraudClient fraudClient,
                              RabbitMQMessageProducer rabbitMQMessageProducer) {

    public void registerCustomer(CustomerRegistrationRequest customerRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRequest.firstName())
                .lastName(customerRequest.lastName())
                .email(customerRequest.email())
                .build();
        // TODO: check email valid
        // TODO: check email not taken

        customerRepository.saveAndFlush(customer);


        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Fraudster customer");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Welcome %s, to our awesome platform!", customer.getFirstName())
        );
        rabbitMQMessageProducer.publish(notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key");
    }
}
