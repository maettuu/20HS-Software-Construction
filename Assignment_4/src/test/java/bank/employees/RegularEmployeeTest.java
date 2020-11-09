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
    RegularEmployee regEmp;
    Customer regCustomer;
    Customer goldenCustomer;

    @BeforeEach
    public void beforeEach(){
        Calendar expDate = Calendar.getInstance();
        expDate.add(Calendar.MONTH,1);
        CreditCard c = new CreditCard(expDate, 123, 1234);
        regCustomer = new Customer("c", "a", 5, Level.REGULAR, c);
        goldenCustomer = new Customer("c", "a", 5, Level.GOLDEN, c);
        regEmp = new RegularEmployee("name", "surname");
        regEmp.addCustomer(regCustomer);
    }

    @Test
    public void testUpgradeToGOLDEN(){
        regEmp.upgradeCustomer(regCustomer.getId());
        assertEquals(Level.GOLDEN, regCustomer.getLevel());
    }

    @Test
    public void testDontUpgradeGOLDEN(){
        regEmp.upgradeCustomer(goldenCustomer.getId());
        assertEquals(Level.GOLDEN, goldenCustomer.getLevel());
    }

    @Test
    public void testUpgradeNonexistentCustomer(){
        regEmp.upgradeCustomer(UUID.randomUUID());
        assertEquals(Level.GOLDEN, goldenCustomer.getLevel());
        assertEquals(Level.REGULAR, regCustomer.getLevel());
    }
}