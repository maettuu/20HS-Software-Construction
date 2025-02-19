package bank.employees;

import bank.CreditCard;
import bank.customers.Customer;
import bank.customers.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The class RegularEmployeeTest consists of tests checking all functionalities
 * a Regular Employee has
 */
class RegularEmployeeTest {
    RegularEmployee regularEmp;
    Customer regularCustomer;
    Customer goldenCustomer;
    Customer unknownCustomer;

    /**
     * This method is used for initialization purposes before each test.
     */
    @BeforeEach
    public void beforeEach(){
        Calendar expDate = Calendar.getInstance();
        expDate.add(Calendar.MONTH,1);
        CreditCard creditCard = new CreditCard(expDate, 123, 1234);
        regularCustomer = getCustomerHelper(Level.REGULAR, creditCard);
        unknownCustomer = getCustomerHelper(Level.REGULAR, creditCard);
        goldenCustomer = getCustomerHelper(Level.GOLDEN, creditCard);
        regularEmp = new RegularEmployee("name", "surname");
        regularEmp.addCustomer(regularCustomer);
    }

    /**
     * This test checks whether the level upgrade (done by a Regular Employee)
     * from a regular to a golden customer works correctly
     */
    @Test
    public void testUpgradeToGOLDEN(){
        regularEmp.upgradeCustomer(regularCustomer.getId());
        assertEquals(Level.GOLDEN, regularCustomer.getLevel());
    }

    /**
     * This test checks whether the level upgrade (done by a Regular Employee)
     * from a golden to a platinum customer is not performed, since the clearance
     * level is not reached
     */
    @Test
    public void testNotUpgradeGOLDEN(){
        regularEmp.upgradeCustomer(goldenCustomer.getId());
        assertEquals(Level.GOLDEN, goldenCustomer.getLevel());
    }

    /**
     * This test checks whether the customer's level is not upgraded if the Regular Employee
     * is not responsible for the customer
     */
    @Test
    public void testNotUpgradeUnknownCustomer(){
        regularEmp.upgradeCustomer(unknownCustomer.getId());
        assertEquals(Level.REGULAR, unknownCustomer.getLevel());
    }

    /**
     * This test checks whether the levels of the Regular Employee's customers change
     * if a random other customer upgrades its level
     */
    @Test
    public void testUpgradeNonexistentCustomer(){
        regularEmp.upgradeCustomer(UUID.randomUUID());
        assertEquals(Level.GOLDEN, goldenCustomer.getLevel());
        assertEquals(Level.REGULAR, regularCustomer.getLevel());
    }

    /**
     * This method is used as a helper to simplify the customer generation
     * @param level REGULAR, GOLDEN or PLATINUM - the level of the customer
     * @param creditCard the credit card assigned to this customer (a dummy in this case,
     *                   since the card is not important)
     * @return Customer new instance of the class Customer
     */
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