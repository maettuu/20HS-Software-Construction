package shuttleServiceTests;

import org.junit.jupiter.api.Test;
import shuttleService.behaviors.luggageBehavior.Limited;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LuggageBehavioursTests {

    @Test
    void negativeNumberExceptionTest(){
        assertThrows(IllegalArgumentException.class, () -> new Limited(-1,2));
        assertThrows(IllegalArgumentException.class, () -> new Limited(2,-1));
        assertThrows(IllegalArgumentException.class, () -> new Limited(-1,-1));
    }

}
