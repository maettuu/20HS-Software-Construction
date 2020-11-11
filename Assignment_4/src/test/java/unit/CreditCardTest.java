package unit;

import bank.CreditCard;
import bank.customers.Customer;
import bank.customers.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

/**
 * The class CreditCardTest consists of tests checking all functionalities
 * that can be applied to a credit card
 */
public class CreditCardTest {
    Customer regularCustomer;
    Customer goldenCustomer;
    Customer platinumCustomer;


    /**
     * This method is used for initialization purposes before each test. The class Calendar is used to create
     * unique expiration dates. A month is added to make the credit card valid.
     */
    @BeforeEach
    public void beforeEach(){
        Calendar expDate = Calendar.getInstance();
        expDate.add(Calendar.MONTH,1);
        CreditCard creditCard = new CreditCard(expDate, 123, 1542);
        regularCustomer = getCustomerHelper(Level.REGULAR, creditCard);
        goldenCustomer = getCustomerHelper(Level.GOLDEN, creditCard);
        platinumCustomer = getCustomerHelper(Level.PLATINUM, creditCard);
    }

    /**
     * This test checks whether the debt is changes once there is a credit card payment
     * which exceeds the limit of level REGULAR
     */
    @Test
    public void CreditCardLimitRegularTest(){
        regularCustomer.payCreditCard(100);
        Assertions.assertEquals(100, regularCustomer.getCreditCard().getDebt());

        regularCustomer.payCreditCard(2100);
        Assertions.assertEquals(100, regularCustomer.getCreditCard().getDebt());

    }

    /**
     * This test checks whether the debt is changes once there is a credit card payment
     * which exceeds the limit of level GOLD
     */
    @Test
    public void CreditCardLimitGoldenTest(){
        goldenCustomer.payCreditCard(3000);
        Assertions.assertEquals(3000, goldenCustomer.getCreditCard().getDebt());

        goldenCustomer.payCreditCard(6000);
        Assertions.assertEquals(3000, goldenCustomer.getCreditCard().getDebt());

    }

    /**
     * This test checks whether the debt is changes once there is a credit card payment
     * which exceeds the limit of level PLATINUM
     */
    @Test
    public void CreditCardLimitPlatinumTest(){
        platinumCustomer.payCreditCard(7000);
        Assertions.assertEquals(7000, platinumCustomer.getCreditCard().getDebt());

        platinumCustomer.payCreditCard(15000);
        Assertions.assertEquals(7000, platinumCustomer.getCreditCard().getDebt());

    }

    /**
     * This test checks whether the payment by credit card is not accepted once the card is
     * expired
     */
    @Test
    public void CreditCardExpirationDateTest(){
        Calendar expDate = Calendar.getInstance();
        expDate.add(Calendar.MONTH,-1);
        CreditCard creditCard = new CreditCard(expDate, 123, 1542);
        Customer customer = getCustomerHelper(Level.PLATINUM, creditCard);

        customer.payCreditCard(100);
        Assertions.assertEquals(0, creditCard.getDebt());
    }

    /**
     * This method is used as a helper to simplify the customer generation
     * @param level REGULAR, GOLDEN or PLATINUM
     * @param creditCard a default credit card is used as dummy, since for these tests
     *                   it's not important
     * @return Customer to help testing
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
