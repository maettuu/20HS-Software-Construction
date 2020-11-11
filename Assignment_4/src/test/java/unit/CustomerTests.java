package unit;

import bank.CreditCard;
import bank.customers.Customer;
import bank.customers.Level;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

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
    public void testCustomerDeposit(){
        customer.deposit(1000);
        assertEquals(1000, customer.getSavings());
    }

    /**
     * This test checks whether the money withdrawal smaller than the total savings works correctly
     */
    @Test
    public void testCustomerWithdraw(){
        customer.deposit(1000);
        assertEquals(1000, customer.getSavings());

        customer.withdraw(400);
        assertEquals(600, customer.getSavings());
    }

    /**
     * This test checks whether all the savings but not more
     * are returned if the withdrawal is higher than the savings
     */
    @Test
    public void testCustomerTooMuchWithdraw(){
        customer.deposit(600);

        float amount = customer.withdraw(1000);
        assertEquals(600, amount);
    }

    /**
     * This test checks whether the payment of a smaller amount than the total savings works correctly
     */
    @Test
    public void testCustomerPayment(){
        customer.deposit(1000);

        customer.pay(400);
        assertEquals(600, customer.getSavings());
    }

    /**
     * This test checks whether a payment is not accepted if it's higher than the customer's savings,
     * hence the savings staying unchanged
     */
    @Test
    public void testCustomerTooHighPayment(){
        customer.deposit(1000);
        assertEquals(1000, customer.getSavings());

        /* Try paying too much money
         */
        customer.pay(2000);
        assertEquals(1000, customer.getSavings());
    }
}
