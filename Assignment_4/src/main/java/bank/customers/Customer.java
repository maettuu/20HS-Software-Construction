package bank.customers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Customer {
    private int id;
    private String name;
    private String surname;
    private int accountNumber;
    private float savings;
}
