package unit;

import bank.customers.Customer;
import bank.customers.Level;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditCardTest {
    @Test
    public void CreditCardLimitRegularTest(){
        Customer customer = new Customer(Level.REGULAR);

        customer.payCreditCard(100);

    }
}
