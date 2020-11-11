package bank.technicians;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The class WebTechnicianTest consists of tests checking all functionalities
 * a Web-Technician has
 */
class WebTechnicianTest {
    WebTechnician technician;

    /**
     * This method is used for initialization purposes before each test.
     */
    @BeforeEach
    public void createTechnician() {
        this.technician = new WebTechnician("Jin", "Sakai");
    }

    /**
     * This test checks whether the fix method really does last for 30 seconds in total
     * @throws InterruptedException thrown if a thread gets interrupted while sleeping
     */
    @Test
    void fix() throws InterruptedException {
        long start = System.nanoTime();
        technician.fix();
        long secondsPassed = (System.nanoTime() - start / 1000000000);
        double expectedSecondsPassed = 29.9;
        assertTrue(secondsPassed >= expectedSecondsPassed);
    }
}