package lk.epic.customer;

import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository repository) {

    public void registerCustomer(CustomerRegistrationRequest request) {

        Customer customer = Customer.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .build();

        repository.save(customer);

    }
}
