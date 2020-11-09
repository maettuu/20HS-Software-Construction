package bank.employees;

import bank.customers.Customer;
import bank.customers.Level;

import java.util.UUID;

public class SectionChief extends RegularEmployee {
    private String city;

    SectionChief(String name, String surname, String city){
        super(name, surname);
        this.city = city;
    }

    void downgradeCustomer(UUID id){
        Customer c = getCustomer(id);
        if (c.getLevel() == Level.GOLDEN){
            c.setLevel(Level.REGULAR);
            return;
        }

        System.out.println("This employee is not responsible for the given customer id " +
                "or the customer has not an appropriate level");
    }

    @Override
    public void upgradeCustomer(UUID id){
        Customer customer = getCustomer(id);

        if (customer.getLevel() == Level.REGULAR){
            customer.setLevel(Level.GOLDEN);
            return;
        }
        else if (customer.getLevel() == Level.GOLDEN){
            customer.setLevel(Level.PLATINUM);
            return;
        }

        System.out.println("This employee is not responsible for the given customer id " +
                "or the customer has not an appropriate level");
    }
}
