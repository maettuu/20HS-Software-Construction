package bank;


import bank.customers.Customer;
import bank.customers.Level;
import lombok.Getter;
import lombok.Setter;

import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import java.util.Calendar;

@Getter
@Setter
public class CreditCard {
    private Customer customer;
    private int serial;
    private int security;
    private Calendar expirationDate;
    private float limit;
    private float debt;
    private Level level;

    public CreditCard(Calendar expirationDate, int serial, int security){
        // TODO the credit card doesn't have a way to access its owners name and surname yet
        this.limit = 2000;
        this.expirationDate = expirationDate;
        this.serial = serial;
        this.security = security;
    }
    // a copy constructor to avoid several customers pointing to the same credit card
    public CreditCard(CreditCard card){
        this.limit = card.getLimit();
        this.expirationDate = card.getExpirationDate();
        this.serial = card.getSerial();
        this.security = card.getSecurity();
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

    public String getOwnerName(){
        return this.customer.getName();
    }

    public String getOwnerSurname(){
        return this.customer.getSurname();
    }


    public void setLevel(Level level){
        this.level = level;
        switch (level){
            case REGULAR: this.setLimit(2000);
                break;
            case GOLDEN: this.setLimit(5000);
                break;
            case PLATINUM: this.setLimit(10000);
                break;
        }
    }
}
