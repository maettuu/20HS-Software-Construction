package bank.employees;

import bank.CreditCard;
import bank.customers.Customer;
import bank.customers.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MainChiefTest {
    MainChief MainChief;
    Customer regularCustomer;
    Customer platinumCustomer;
    Customer goldenCustomer;

    @BeforeEach
    public void beforeEach(){
        Calendar expDate = Calendar.getInstance();
        expDate.add(Calendar.MONTH,1);
        CreditCard creditCard = new CreditCard(expDate, 123, 1234);
        regularCustomer = getCustomerHelper(Level.REGULAR, creditCard);
        goldenCustomer = getCustomerHelper(Level.GOLDEN, creditCard);
        platinumCustomer = getCustomerHelper(Level.PLATINUM, creditCard);
        MainChief = new MainChief("name", "surname");
        MainChief.addCustomer(goldenCustomer);
    }

    @Test
    public void testUpgradeToGOLDEN(){
        MainChief.upgradeCustomer(regularCustomer.getId());
        assertEquals(Level.GOLDEN, regularCustomer.getLevel());
    }

    @Test
    public void testUpgradeToPLATINUM(){
        MainChief.upgradeCustomer(goldenCustomer.getId());
        assertEquals(Level.PLATINUM, goldenCustomer.getLevel());
    }

    @Test
    public void testDowngradeToREGULAR(){
        MainChief.downgradeCustomer(goldenCustomer.getId());
        assertEquals(Level.REGULAR, goldenCustomer.getLevel());
    }

    @Test
    public void testDowngradeToGOLDEN(){
        MainChief.downgradeCustomer(platinumCustomer.getId());
        assertEquals(Level.GOLDEN, platinumCustomer.getLevel());
    }

    @Test
    public void testUpgradeNonexistentCustomer(){
        MainChief.upgradeCustomer(UUID.randomUUID());
        assertEquals(Level.GOLDEN, goldenCustomer.getLevel());
        assertEquals(Level.PLATINUM, platinumCustomer.getLevel());
    }

    @Test
    public void testDowngradeNonexistentCustomer(){
        MainChief.downgradeCustomer(UUID.randomUUID());
        assertEquals(Level.GOLDEN, goldenCustomer.getLevel());
        assertEquals(Level.PLATINUM, platinumCustomer.getLevel());
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