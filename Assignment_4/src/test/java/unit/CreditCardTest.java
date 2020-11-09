package unit;

import bank.CreditCard;
import bank.customers.Customer;
import bank.customers.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class CreditCardTest {
    Customer regularCustomer;
    Customer goldCustomer;
    Customer platinCustomer;


    @BeforeEach
    public void beforeEach(){
        Calendar expDate = Calendar.getInstance();
        expDate.add(Calendar.MONTH,1);
        CreditCard creditCard = new CreditCard(expDate, 123, 1542);
        regularCustomer = getCustomerHelper(Level.REGULAR, creditCard);
        goldCustomer = getCustomerHelper(Level.GOLDEN, creditCard);
        platinCustomer = getCustomerHelper(Level.PLATINUM, creditCard);
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
        goldCustomer.payCreditCard(3000);
        Assertions.assertEquals(3000, goldCustomer.getCreditCard().getDebt());

        /**
         * Exceeds limit, does not change debt
         */
        goldCustomer.payCreditCard(6000);
        Assertions.assertEquals(3000, goldCustomer.getCreditCard().getDebt());

    }

    @Test
    public void CreditCardLimitPlatinumTest(){
        platinCustomer.payCreditCard(7000);
        Assertions.assertEquals(7000, platinCustomer.getCreditCard().getDebt());

        /**
         * Exceeds limit, does not change debt
         */
        platinCustomer.payCreditCard(15000);
        Assertions.assertEquals(7000, platinCustomer.getCreditCard().getDebt());

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
