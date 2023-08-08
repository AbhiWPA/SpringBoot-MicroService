package lk.epic.customer;

public record CustomerRegistrationRequest(
        String firstname,
        String lastname,
        String email

) {
}
