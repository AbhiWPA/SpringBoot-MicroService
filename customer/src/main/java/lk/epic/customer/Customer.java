package lk.epic.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    private int id;
    private String firstname;
    private String lastname;
    private String email;

}
