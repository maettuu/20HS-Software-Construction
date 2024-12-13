package bank.employees;

import bank.CreditCard;
import bank.Person;
import bank.customers.Customer;
import bank.customers.Level;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

@Getter
@Setter
public class RegularEmployee extends Person {
    protected Customer dummyCustomer;
    protected ArrayList<Customer> customers;

    public RegularEmployee(String name, String surname){
        super(name, surname);
        this.customers = new ArrayList<>();
    }

    public void upgradeCustomer(UUID id){
        Customer customer = getCustomer(id);
        if (customer.getLevel() == Level.REGULAR){
            customer.setLevel(Level.GOLDEN);
        }
        else if (customer.getLevel() == Level.GOLDEN){
            System.out.println("Please contact a Section Chief to perform this operation");
        }
        else {
            System.out.println("Please contact a Main Chief to perform this operation");
        }
    }

    protected Customer getCustomer(UUID id){
        for (Customer customer: customers){
            if(customer.getId() == id){return customer;}
        }

        if(dummyCustomer == null){
            Calendar expDate = Calendar.getInstance();
            expDate.add(Calendar.MONTH,1);
            CreditCard creditCard = new CreditCard(expDate, 123, 1542);
            dummyCustomer = new Customer(
                    "name",
                    "surname",
                    0,
                    Level.GOLDEN,
                    creditCard
            );
        }

        System.out.println("This employee is not responsible for the given customer ID");
        return dummyCustomer;
    }

    public void addCustomer(Customer customer){
        if(customers.contains(customer)){
            System.out.println("This employee already has this customer!");
            return;
        }
        this.customers.add(customer);
    }

}
