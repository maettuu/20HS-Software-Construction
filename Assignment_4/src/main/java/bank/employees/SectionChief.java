package bank.employees;

import bank.customers.Customer;
import bank.customers.Level;

import java.util.UUID;

public class SectionChief extends RegularEmployee {
    private String city;

    public SectionChief(String name, String surname, String city){
        super(name, surname);
        this.city = city;
    }

    public void downgradeCustomer(UUID id){
        Customer customer = getCustomer(id);
        if (customer.getLevel() == Level.REGULAR){
            System.out.println("This customer already has the lowest level possible");
        }
        else if (customer.getLevel() == Level.GOLDEN){
            customer.setLevel(Level.REGULAR);
        }
        else {
            System.out.println("Please contact a Main Chief to perform this operation");
        }
    }

    @Override
    public void upgradeCustomer(UUID id){
        Customer customer = getCustomer(id);
        if (customer.getLevel() == Level.REGULAR){
            customer.setLevel(Level.GOLDEN);
        }
        else if (customer.getLevel() == Level.GOLDEN){
            customer.setLevel(Level.PLATINUM);
        }
        else {
            System.out.println("This customer already has the highest level possible");
        }
    }
}
