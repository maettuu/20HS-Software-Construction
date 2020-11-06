package bank.customers;


import bank.CreditCard;

public class PlatinumCustomer extends bank.customers.Customer {
    public PlatinumCustomer(){
        this.setCreditCard(new CreditCard( 10000));
    }
}
