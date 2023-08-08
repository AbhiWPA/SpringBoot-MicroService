package lk.epic.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

    private String id;
    private String firstname;
    private String lastname;
    private String email;

}
