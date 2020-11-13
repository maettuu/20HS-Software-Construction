package unit;

import bank.CreditCard;
import bank.customers.Customer;
import bank.customers.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
     * This test checks whether the debt is changed correctly if there is a credit card payment
     * not exceeding the limit
     */
    @Test
    public void testCreditCardDebt(){
        regularCustomer.payCreditCard(100);
        assertEquals(100, regularCustomer.getCreditCard().getDebt());
    }

    /**
     * This test checks whether the debt is changed once there is a credit card payment
     * which exceeds the limit of level REGULAR
     */
    @Test
    public void testCreditCardLimitRegular(){
        regularCustomer.payCreditCard(100);
        assertEquals(100, regularCustomer.getCreditCard().getDebt());

        regularCustomer.payCreditCard(2100);
        assertEquals(100, regularCustomer.getCreditCard().getDebt());

    }

    /**
     * This test checks whether the debt is changes once there is a credit card payment
     * which exceeds the limit of level GOLD
     */
    @Test
    public void testCreditCardLimitGolden(){
        goldenCustomer.payCreditCard(3000);
        assertEquals(3000, goldenCustomer.getCreditCard().getDebt());

        goldenCustomer.payCreditCard(6000);
        assertEquals(3000, goldenCustomer.getCreditCard().getDebt());

    }

    /**
     * This test checks whether the debt is changes once there is a credit card payment
     * which exceeds the limit of level PLATINUM
     */
    @Test
    public void testCreditCardLimitPlatinum(){
        platinumCustomer.payCreditCard(7000);
        assertEquals(7000, platinumCustomer.getCreditCard().getDebt());

        platinumCustomer.payCreditCard(15000);
        assertEquals(7000, platinumCustomer.getCreditCard().getDebt());

    }

    /**
     * This test checks whether the payment by credit card is not accepted once the card is
     * expired
     */
    @Test
    public void testCreditCardExpirationDate(){
        Calendar expDate = Calendar.getInstance();
        expDate.add(Calendar.MONTH,-1);
        CreditCard creditCard = new CreditCard(expDate, 123, 1542);
        Customer customer = getCustomerHelper(Level.PLATINUM, creditCard);

        customer.payCreditCard(100);
        assertEquals(0, creditCard.getDebt());
    }

    /**
     * This test checks if a credit card returns the correct owner name.
     */
    @Test
    public void testGetName(){
        CreditCard card = regularCustomer.getCreditCard();
        assertEquals(card.getOwnerName(), "name");
    }

    /**
     * This test checks if the credit card returns the correct owner surname.
     */
    @Test
    public void testGetSurname(){
        CreditCard card = regularCustomer.getCreditCard();
        assertEquals(card.getOwnerName(), "surname");
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
