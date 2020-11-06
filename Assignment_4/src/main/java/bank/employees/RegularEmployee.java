package bank.employees;

import bank.CreditCard;
import bank.Person;
import bank.customers.Customer;
import bank.customers.Level;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class RegularEmployee extends Person {

    protected ArrayList<Customer> customers;

    RegularEmployee(String name, String surname, int id){
        super(name, surname, id);
        this.customers = new ArrayList<>();
    }

    void upgradeCustomer(int id){
        for (Customer customer : customers){
            if (customer.getId() == id && customer.getLevel() == Level.REGULAR){
                customer.setLevel(Level.GOLDEN);
                return;
            }
        }
        System.out.println("This employee is not responsible for the given customer id " +
                "or the customer has not an appropriate level");
    }

}
