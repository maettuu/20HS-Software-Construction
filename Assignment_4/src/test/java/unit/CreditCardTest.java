package unit;

import bank.CreditCard;
import bank.customers.Customer;
import bank.customers.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class CreditCardTest {
    @Test
    public void CreditCardLimitRegularTest(){
        Calendar expDate = Calendar.getInstance();
        expDate.add(Calendar.MONTH,1);
        CreditCard creditCard = new CreditCard(expDate, 123, 1542);
        Customer customer = new Customer(
                "name",
                "surname",
                1,
                1,
                Level.REGULAR,
                creditCard
        );

        customer.payCreditCard(100);
        Assertions.assertEquals(100, creditCard.getDebt());

        /**
         * Exceeds limit, does not change debt
         */
        customer.payCreditCard(2100);
        Assertions.assertEquals(100, creditCard.getDebt());

    }

    @Test
    public void CreditCardLimitGoldenTest(){
        Calendar expDate = Calendar.getInstance();
        expDate.add(Calendar.MONTH,1);
        CreditCard creditCard = new CreditCard(expDate, 123, 1542);
        Customer customer = new Customer(
                "name",
                "surname",
                1,
                1,
                Level.GOLDEN,
                creditCard
        );

        customer.payCreditCard(3000);
        Assertions.assertEquals(3000, creditCard.getDebt());

        /**
         * Exceeds limit, does not change debt
         */
        customer.payCreditCard(6000);
        Assertions.assertEquals(3000, creditCard.getDebt());

    }

    @Test
    public void CreditCardLimitPlatinumTest(){
        Calendar expDate = Calendar.getInstance();
        expDate.add(Calendar.MONTH,1);
        CreditCard creditCard = new CreditCard(expDate, 123, 1542);
        Customer customer = new Customer(
                "name",
                "surname",
                1,
                1,
                Level.PLATINUM,
                creditCard
        );

        customer.payCreditCard(7000);
        Assertions.assertEquals(7000, creditCard.getDebt());

        /**
         * Exceeds limit, does not change debt
         */
        customer.payCreditCard(15000);
        Assertions.assertEquals(7000, creditCard.getDebt());

    }

    @Test
    public void CreditCardExpirationDateTest(){
        Calendar expDate = Calendar.getInstance();
        expDate.add(Calendar.MONTH,-1);
        CreditCard creditCard = new CreditCard(expDate, 123, 1542);
        Customer customer = new Customer(
                "name",
                "surname",
                1,
                1,
                Level.PLATINUM,
                creditCard
        );

        /**
         * Payment not accpeted because of expiration date
         */
        customer.payCreditCard(100);
        Assertions.assertEquals(0, creditCard.getDebt());
    }
}
