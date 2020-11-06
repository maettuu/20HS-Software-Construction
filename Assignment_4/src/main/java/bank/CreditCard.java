package bank;


import bank.customers.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreditCard {
    private Customer customer;
    private int serial;
    private int security;
    private Date expirationDate;
    private float limit;
    private float debt;

    public CreditCard(float limit){
        this.limit = limit;
    }

    public void pay(float amount){
        if (new Date().getTime() > this.expirationDate.getTime()){
            System.out.println("Expiration date reached, payment denied");
            return;
        }
        if(amount <= this.limit){
            this.debt += amount;
            return;
        }
        System.out.println("Amount exceeded limit, payment denied!");
    }
}
