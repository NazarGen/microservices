package com.appcode.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstNam())
                .lastName(request.lastName())
                .email(request.email())
                .build();


        customerRepository.saveAndFlush(customer);

        FraudCheckResponsec fraudCheckResponsec = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponsec.class,
                customer.getId()
        );

        if (fraudCheckResponsec.isFraudster()){
            throw  new IllegalStateException("fraudster");
        }




    }
}
