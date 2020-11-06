package unit;

import bank.customers.Customer;
import bank.customers.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTests {
    @Test
    public void CustomerDepositTest(){
        Customer customer = new Customer(Level.REGULAR);
        customer.deposit(1000);
        Assertions.assertEquals(1000, customer.getSavings());
    }

    @Test
    public void CustomerWithdrawTest(){
        Customer customer = new Customer(Level.REGULAR);
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
        Customer customer = new Customer(Level.REGULAR);
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
