package unit;

import bank.CreditCard;
import bank.customers.Customer;
import bank.customers.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class CustomerTests {
    private Customer customer;
    private CreditCard creditCard;

    @BeforeEach
    public void beforeEach(){
        Calendar expDate = Calendar.getInstance();
        expDate.add(Calendar.MONTH,1);
        creditCard = new CreditCard(expDate, 123, 1542);

        customer = new Customer(
                "name",
                "surname",
                1,
                Level.REGULAR,
                creditCard
        );
    }

    @Test
    public void customerDepositTest(){
        customer.deposit(1000);
        Assertions.assertEquals(1000, customer.getSavings());
    }

    @Test
    public void customerWithdrawTest(){
        customer.deposit(1000);
        Assertions.assertEquals(1000, customer.getSavings());

        customer.withdraw(400);
        Assertions.assertEquals(600, customer.getSavings());

        // Try widthdrawing too much money
        float amount = customer.withdraw(1000);
        Assertions.assertEquals(600, amount);
    }

    @Test
    public void customerPaymentTest(){
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
}
