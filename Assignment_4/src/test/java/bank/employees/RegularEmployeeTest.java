package bank.employees;

import bank.CreditCard;
import bank.customers.Customer;
import bank.customers.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class RegularEmployeeTest {
    RegularEmployee regularEmp;
    Customer regularCustomer;
    Customer goldenCustomer;

    @BeforeEach
    public void beforeEach(){
        Calendar expDate = Calendar.getInstance();
        expDate.add(Calendar.MONTH,1);
        CreditCard creditCard = new CreditCard(expDate, 123, 1234);
        regularCustomer = getCustomerHelper(Level.REGULAR, creditCard);
        goldenCustomer = getCustomerHelper(Level.GOLDEN, creditCard);
        regularEmp = new RegularEmployee("name", "surname");
        regularEmp.addCustomer(regularCustomer);
    }

    @Test
    public void testUpgradeToGOLDEN(){
        regularEmp.upgradeCustomer(regularCustomer.getId());
        assertEquals(Level.GOLDEN, regularCustomer.getLevel());
    }

    @Test
    public void testNotUpgradeGOLDEN(){
        regularEmp.upgradeCustomer(goldenCustomer.getId());
        assertEquals(Level.GOLDEN, goldenCustomer.getLevel());
    }

    @Test
    public void testUpgradeNonexistentCustomer(){
        regularEmp.upgradeCustomer(UUID.randomUUID());
        assertEquals(Level.GOLDEN, goldenCustomer.getLevel());
        assertEquals(Level.REGULAR, regularCustomer.getLevel());
    }

    public Customer getCustomerHelper(Level level, CreditCard creditCard){
        return new Customer(
                "name",
                "surname",
                1,
                level,
                creditCard
        );
    }
}