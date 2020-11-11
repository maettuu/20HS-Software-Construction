package bank.technicians;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The class BackendTechnicianTest consists of tests checking all functionalities
 * a Backend-Technician has
 */
class BackendTechnicianTest {
    BackendTechnician technician;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream(); //used to check console for print statements

    /**
     * This method is used for initialization purposes before each test.
     */
    @BeforeEach
    public void setUp() {
        this.technician = new BackendTechnician("Yuna", "");
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    /**
     * This test checks whether the print statement is indeed printed after the method technician.fix is called
     */
    @Test
    public void testFix(){
        technician.fix(technician.getId());
        assertEquals("fixed!", outputStreamCaptor.toString().trim());
    }

    /**
     * This method is used to correctly stop the PrintStream
     */
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}