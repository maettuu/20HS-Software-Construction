package bank.customers;

import bank.CreditCard;

public class RegularCustomer extends bank.customers.Customer {
    public RegularCustomer(){
        this.setCreditCard(new CreditCard(2000));
    }
}
