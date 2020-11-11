package unit;

import bank.CreditCard;
import bank.customers.Customer;
import bank.customers.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * The class CustomerTests consists of tests checking all actions a customer can perform
 */
public class CustomerTests {
    private Customer customer;
    private CreditCard creditCard;

    /**
     * This method is used for initialization purposes before each test.
     */
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

    /**
     * This test checks whether the deposit method works correctly
     */
    @Test
    public void customerDepositTest(){
        customer.deposit(1000);
        Assertions.assertEquals(1000, customer.getSavings());
    }

    /**
     * This test checks whether the money withdrawal smaller than the total savings works correctly
     */
    @Test
    public void customerWithdrawTest(){
        customer.deposit(1000);
        Assertions.assertEquals(1000, customer.getSavings());

        customer.withdraw(400);
        Assertions.assertEquals(600, customer.getSavings());
    }

    /**
     * This test checks whether all the savings but not more
     * are returned if the withdrawal is higher than the savings
     */
    @Test
    public void customerTooMuchWithdrawTest(){
        customer.deposit(600);

        float amount = customer.withdraw(1000);
        Assertions.assertEquals(600, amount);
    }

    /**
     * This test checks whether the payment of a smaller amount than the total savings works correctly
     */
    @Test
    public void customerPaymentTest(){
        customer.deposit(1000);

        customer.pay(400);
        Assertions.assertEquals(600, customer.getSavings());
    }

    /**
     * This test checks whether a payment is not accepted if it's higher than the customer's savings,
     * hence the savings staying unchanged
     */
    @Test
    public void customerTooHighPaymentTest(){
        customer.deposit(1000);
        Assertions.assertEquals(1000, customer.getSavings());

        /* Try paying too much money
         */
        customer.pay(2000);
        Assertions.assertEquals(1000, customer.getSavings());
    }
}
