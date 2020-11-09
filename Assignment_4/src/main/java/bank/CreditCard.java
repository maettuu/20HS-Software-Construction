package bank;


import bank.customers.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import java.util.Calendar;

/**
 * TODO: What happens with money paid by credit card???
 */
@Getter
@Setter
public class CreditCard {
    private Customer customer;
    private int serial;
    private int security;
    private Calendar expirationDate;
    private float limit;
    private float debt;

    public CreditCard(Calendar expirationDate, int serial, int security){
        this.limit = 2000;
        this.expirationDate = expirationDate;
        this.serial = serial;
        this.security = security;
    }
    // a copy constructor to avoid several customers pointing to the same credit card
    public CreditCard(CreditCard c){
        this.limit = c.getLimit();
        this.expirationDate = c.getExpirationDate();
        this.serial = c.getSerial();
        this.security = c.getSecurity();
    }

    public void pay(float amount){
        if (this.expirationDate.compareTo(Calendar.getInstance()) < 0){
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
