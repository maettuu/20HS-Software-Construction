package bank.technicians;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WebTechnicianTest {
    WebTechnician technician;

    @BeforeEach
    public void beforeEach() {
        this.technician = new WebTechnician("Jin", "Sakai");
    }

    // TODO This test is kind of retarded. Is this really necessary?
    @Test
    void fix() throws InterruptedException {
        long start = System.nanoTime();
        technician.fix();
        long secondsPassed = (System.nanoTime() - start / 1000000000);
        double expectedSecondsPassed = 29.9;
        assertTrue(secondsPassed >= expectedSecondsPassed);
    }
}