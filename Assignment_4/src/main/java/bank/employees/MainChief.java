package bank.employees;

import bank.customers.Customer;
import bank.customers.Level;

public class MainChief extends RegularEmployee {
    MainChief(String name, String surname, int id) {
        super(name, surname, id);
    }

    void downgradeCustomer(int id){
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
