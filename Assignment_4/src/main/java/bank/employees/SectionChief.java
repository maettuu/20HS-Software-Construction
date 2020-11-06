package bank.employees;

import bank.customers.Customer;
import bank.customers.Level;

public class SectionChief extends RegularEmployee {
    private String city;

    SectionChief(String city){
        this.city = city;
    }

    void downgradeCustomer(int id){
        for (Customer customer : customers){
            if (customer.getId() == id && customer.getLevel() == Level.GOLDEN){
                customer.setLevel(Level.REGULAR);
                return;
            }
        }
        System.out.println("This employee is not responsible for the given customer id " +
                "or the customer has not an appropriate level");
    }

    @Override
    void upgradeCustomer(int id){
        for (Customer customer : customers){
            if (customer.getId() == id && customer.getLevel() == Level.REGULAR){
                customer.setLevel(Level.GOLDEN);
                return;
            }
            else if (customer.getId() == id && customer.getLevel() == Level.GOLDEN){
                customer.setLevel(Level.PLATINUM);
                return;
            }
        }
        System.out.println("This employee is not responsible for the given customer id " +
                "or the customer has not an appropriate level");
    }
}
