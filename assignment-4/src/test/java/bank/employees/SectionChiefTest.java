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
 * The class SectionChiefTest consists of tests checking all functionalities
 * a Section Chief has
 */
class SectionChiefTest {
    SectionChief secChief;
    Customer regularCustomer;
    Customer platinumCustomer;
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
        goldenCustomer = getCustomerHelper(Level.GOLDEN, creditCard);
        platinumCustomer = getCustomerHelper(Level.PLATINUM, creditCard);
        unknownCustomer = getCustomerHelper(Level.GOLDEN, creditCard);
        secChief = new SectionChief("name", "surname", "city");
        secChief.addCustomer(regularCustomer);
        secChief.addCustomer(goldenCustomer);
    }

    /**
     * This test checks whether the level upgrade (done by a Section Chief)
     * from a regular to a golden customer works correctly
     */
    @Test
    public void testUpgradeToGOLDEN(){
        secChief.upgradeCustomer(regularCustomer.getId());
        assertEquals(Level.GOLDEN, regularCustomer.getLevel());
    }

    /**
     * This test checks whether the level upgrade (done by a Section Chief)
     * from a golden to a platinum customer works correctly
     */
    @Test
    public void testUpgradeToPLATINUM(){
        secChief.upgradeCustomer(goldenCustomer.getId());
        assertEquals(Level.PLATINUM, goldenCustomer.getLevel());
    }

    /**
     * This test checks whether the level upgrade (done by a Section Chief)
     * from a platinum customer is not accepted
     */
    @Test
    public void testNotUpgradePLATINUM(){
        secChief.upgradeCustomer(platinumCustomer.getId());
        assertEquals(Level.PLATINUM, platinumCustomer.getLevel());
    }

    /**
     * This test checks whether the customer's level is not upgraded if the Section Chief
     * is not responsible for the customer
     */
    @Test
    public void testNotUpgradeUnknownCustomer(){
        secChief.upgradeCustomer(unknownCustomer.getId());
        assertEquals(Level.GOLDEN, unknownCustomer.getLevel());
    }

    /**
     * This test checks whether the level downgrade (done by a Section Chief)
     * from a golden to a regular customer works correctly
     */
    @Test
    public void testDowngradeToREGULAR(){
        secChief.downgradeCustomer(goldenCustomer.getId());
        assertEquals(Level.REGULAR, goldenCustomer.getLevel());
    }

    /**
     * This test checks whether the level downgrade (done by a Section Chief)
     * from a platinum to a golden customer is not performed, since the clearance
     * level is not reached
     */
    @Test
    public void testNotDowngradePLATINUM(){
        secChief.downgradeCustomer(platinumCustomer.getId());
        assertEquals(Level.PLATINUM, platinumCustomer.getLevel());
    }

    /**
     * This test checks whether the level downgrade (done by a Section Chief)
     * from a regular customer is not accepted
     */
    @Test
    public void testNotDowngradeREGULAR(){
        secChief.downgradeCustomer(regularCustomer.getId());
        assertEquals(Level.REGULAR, regularCustomer.getLevel());
    }

    /**
     * This test checks whether the customer's level is not downgraded if the Main Chief
     * is not responsible for the customer
     */
    @Test
    public void testNotDowngradeUnknownCustomer(){
        secChief.downgradeCustomer(unknownCustomer.getId());
        assertEquals(Level.GOLDEN, unknownCustomer.getLevel());
    }

    /**
     * This test checks whether the levels of the Section Chief's customers change
     * if a random other customer upgrades its level
     */
    @Test
    public void testUpgradeNonexistentCustomer(){
        secChief.upgradeCustomer(UUID.randomUUID());
        assertEquals(Level.GOLDEN, goldenCustomer.getLevel());
        assertEquals(Level.PLATINUM, platinumCustomer.getLevel());
    }

    /**
     * This test checks whether the levels of the Section Chief's customers change
     * if a random other customer downgrades its level
     */
    @Test
    public void testDowngradeNonexistentCustomer(){
        secChief.downgradeCustomer(UUID.randomUUID());
        assertEquals(Level.GOLDEN, goldenCustomer.getLevel());
        assertEquals(Level.PLATINUM, platinumCustomer.getLevel());
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