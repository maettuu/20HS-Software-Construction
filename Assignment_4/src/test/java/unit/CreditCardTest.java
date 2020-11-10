package unit;

import bank.CreditCard;
import bank.customers.Customer;
import bank.customers.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

public class CreditCardTest {
    Customer regularCustomer;
    Customer goldenCustomer;
    Customer platinumCustomer;


    @BeforeEach
    public void beforeEach(){
        Calendar expDate = Calendar.getInstance();
        expDate.add(Calendar.MONTH,1);
        CreditCard creditCard = new CreditCard(expDate, 123, 1542);
        regularCustomer = getCustomerHelper(Level.REGULAR, creditCard);
        goldenCustomer = getCustomerHelper(Level.GOLDEN, creditCard);
        platinumCustomer = getCustomerHelper(Level.PLATINUM, creditCard);
    }

    @Test
    public void CreditCardLimitRegularTest(){
        regularCustomer.payCreditCard(100);
        Assertions.assertEquals(100, regularCustomer.getCreditCard().getDebt());

        /**
         * Exceeds limit, does not change debt
         */
        regularCustomer.payCreditCard(2100);
        Assertions.assertEquals(100, regularCustomer.getCreditCard().getDebt());

    }

    @Test
    public void CreditCardLimitGoldenTest(){
        goldenCustomer.payCreditCard(3000);
        Assertions.assertEquals(3000, goldenCustomer.getCreditCard().getDebt());

        /**
         * Exceeds limit, does not change debt
         */
        goldenCustomer.payCreditCard(6000);
        Assertions.assertEquals(3000, goldenCustomer.getCreditCard().getDebt());

    }

    @Test
    public void CreditCardLimitPlatinumTest(){
        platinumCustomer.payCreditCard(7000);
        Assertions.assertEquals(7000, platinumCustomer.getCreditCard().getDebt());

        /**
         * Exceeds limit, does not change debt
         */
        platinumCustomer.payCreditCard(15000);
        Assertions.assertEquals(7000, platinumCustomer.getCreditCard().getDebt());

    }

    @Test
    public void CreditCardExpirationDateTest(){
        Calendar expDate = Calendar.getInstance();
        expDate.add(Calendar.MONTH,-1);
        CreditCard creditCard = new CreditCard(expDate, 123, 1542);
        Customer customer = getCustomerHelper(Level.PLATINUM, creditCard);

        /**
         * Payment not accpeted because of expiration date
         */
        customer.payCreditCard(100);
        Assertions.assertEquals(0, creditCard.getDebt());
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
