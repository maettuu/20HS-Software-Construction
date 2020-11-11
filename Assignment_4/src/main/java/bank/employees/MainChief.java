package bank.employees;

import bank.customers.Customer;
import bank.customers.Level;

import java.util.UUID;

public class MainChief extends RegularEmployee {
    public MainChief(String name, String surname) {
        super(name, surname);
    }

    public void downgradeCustomer(UUID id){
        for (Customer customer : customers){
            if (customer.getId() == id && customer.getLevel() == Level.GOLDEN){
                customer.setLevel(Level.REGULAR);
                return;
            }
            if (customer.getId() == id && customer.getLevel() == Level.PLATINUM){
                customer.setLevel(Level.GOLDEN);
                return;
            }
        }
        System.out.println("This employee is not responsible for the given customer id " +
                "or the customer has not an appropriate level");
    }

    @Override
    public void upgradeCustomer(UUID id){
        Customer c = getCustomer(id);
        if (c.getLevel() == Level.REGULAR) {
            c.setLevel(Level.GOLDEN);
            return;
        }
        else if (c.getLevel() == Level.GOLDEN){
            c.setLevel(Level.PLATINUM);
            return;
        }
        System.out.println("This employee is not responsible for the given customer id " +
                "or the customer has not an appropriate level");
    }
}
