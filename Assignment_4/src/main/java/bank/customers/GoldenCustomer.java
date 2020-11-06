package bank.customers;


import bank.CreditCard;

public class GoldenCustomer extends bank.customers.Customer {
    public GoldenCustomer(){
        this.setCreditCard(new CreditCard( 5000));
    }
}
