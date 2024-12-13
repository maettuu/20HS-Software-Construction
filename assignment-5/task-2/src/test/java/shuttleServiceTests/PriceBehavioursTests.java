package shuttleServiceTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import shuttleService.Customer;
import shuttleService.behaviors.luggageBehavior.Limited;
import shuttleService.behaviors.priceBehavior.Constant;
import shuttleService.behaviors.priceBehavior.PerHour;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PriceBehavioursTests {
    @Test
    void negativeNumberExceptionTest(){
        assertThrows(IllegalArgumentException.class, () -> new PerHour(-1));
        assertThrows(IllegalArgumentException.class, () -> new Constant(-1));
    }

}
