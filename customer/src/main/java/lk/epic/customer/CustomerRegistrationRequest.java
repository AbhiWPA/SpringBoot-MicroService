package lk.epic.customer;

public record CustomerRegistrationRequest(

        int id,
        String firstname,
        String lastname,
        String email

) {
}
