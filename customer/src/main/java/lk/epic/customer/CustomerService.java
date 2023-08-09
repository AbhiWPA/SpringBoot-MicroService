package lk.epic.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService{

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) {

        Customer customer = Customer.builder()
                .id(request.id())
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .build();

        customerRepository.saveAndFlush(customer);
        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()

        );
        
        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("Fraudster");
        }


    }
}
