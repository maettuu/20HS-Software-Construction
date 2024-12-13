package bank.employees;

import bank.customers.Customer;
import bank.customers.Level;

import java.util.UUID;

public class MainChief extends RegularEmployee {
    public MainChief(String name, String surname) {
        super(name, surname);
    }

    public void downgradeCustomer(UUID id){
        Customer customer = getCustomer(id);
        if (customer.getLevel() == Level.GOLDEN){
            customer.setLevel(Level.REGULAR);
        }
        else if (customer.getLevel() == Level.PLATINUM){
            customer.setLevel(Level.GOLDEN);
        }
        else {
            System.out.println("This customer already has the lowest level possible");
        }
    }

    @Override
    public void upgradeCustomer(UUID id){
        Customer customer = getCustomer(id);
        if (customer.getLevel() == Level.REGULAR) {
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
