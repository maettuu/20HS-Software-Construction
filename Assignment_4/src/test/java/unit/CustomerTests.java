package unit;

import bank.CreditCard;
import bank.customers.Customer;
import bank.customers.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class CustomerTests {
    @Test
    public void CustomerDepositTest(){
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

        customer.deposit(1000);
        Assertions.assertEquals(1000, customer.getSavings());
    }

    @Test
    public void CustomerWithdrawTest(){
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
        customer.deposit(1000);
        Assertions.assertEquals(1000, customer.getSavings());
        customer.withdraw(400);
        Assertions.assertEquals(600, customer.getSavings());

        // Try widthdrawing too much money
        float amount = customer.withdraw(1000);
        Assertions.assertEquals(600, amount);
    }

    @Test
    public void CustomerPaymentTest(){
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
        customer.deposit(1000);
        Assertions.assertEquals(1000, customer.getSavings());

        /* Try paying too much money
         */
        customer.pay(2000);
        Assertions.assertEquals(1000, customer.getSavings());

        /**
         * Try paying right amount of money
         */
        customer.pay(400);
        Assertions.assertEquals(600, customer.getSavings());
    }

    @Test
    public void testIdIsUnique(){
        // TODO
        Assertions.assertEquals(1, 0);
    }
}
