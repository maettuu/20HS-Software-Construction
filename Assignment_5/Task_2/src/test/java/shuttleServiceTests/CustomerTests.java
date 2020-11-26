package shuttleServiceTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shuttleService.Customer;
import shuttleService.vehicles.Bus;
import shuttleService.vehicles.FamilyCar;
import shuttleService.vehicles.MicroCar;
import shuttleService.vehicles.SuperCar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerTests {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream(); //used to check console for print statements

    private Customer customer;

    /**
     * This method is used for initialization purposes before each test.
     */
    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void busTest(){
        Customer customerBus = new Customer(new Bus(), Calendar.getInstance());
        customerBus.ride();
        assertEquals("Bus; diesel; unlimited luggage capacity; slow speed; 5 CHF", outputStreamCaptor.toString().trim());
    }

    @Test
    void familyCarTest(){
        Customer customerBus = new Customer(new FamilyCar(), Calendar.getInstance());
        customerBus.ride();
        assertEquals("Family Car; gasoline; 2 small bag(s) and 2 large bag(s); normal speed; 15 CHF/h", outputStreamCaptor.toString().trim());

    }

    @Test
    void superCarTest(){
        Customer customerBus = new Customer(new SuperCar(), Calendar.getInstance());
        customerBus.ride();
        assertEquals("Super Car; gasoline; 1 small bag(s) and 1 large bag(s); fast speed; 30 CHF/h", outputStreamCaptor.toString().trim());

    }

    @Test
    void microCarTest(){
        Customer customerBus = new Customer(new MicroCar(), Calendar.getInstance());
        customerBus.ride();
        assertEquals("Micro Car; electric; 1 small bag(s); normal speed; 12 CHF/h", outputStreamCaptor.toString().trim());
    }

    @Test
    void nullPointerVehicleExceptionTest() {
        Customer customer =  new Customer(null, Calendar.getInstance());
        assertThrows(NullPointerException.class, () -> customer.ride());
    }


}
