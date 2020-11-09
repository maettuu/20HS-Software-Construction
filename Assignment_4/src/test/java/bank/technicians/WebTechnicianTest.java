package bank.technicians;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebTechnicianTest {
    WebTechnician technician;

    @BeforeEach
    public void beforeEach() {
        this.technician = new WebTechnician();
    }

    // TODO this test increases the execution time by a lot and doesn't make much sense. Remove it if possible.
    @Test
    void fix() throws InterruptedException {
        long start = System.nanoTime();
        technician.fix();
        long secondsPassed = (System.nanoTime() - start / 1000000000);
        double expectedSecondsPassed = 29.9;
        assertTrue(secondsPassed >= expectedSecondsPassed);
    }
}