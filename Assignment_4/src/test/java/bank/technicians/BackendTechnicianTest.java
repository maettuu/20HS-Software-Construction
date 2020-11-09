package bank.technicians;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BackendTechnicianTest {
    BackendTechnician technician;

    @BeforeEach
    public void createTechnician(){
        this.technician = new BackendTechnician("Yuna", "");
    }

    @Test
    public void testFix(){
        technician.fix(50);
    }
}