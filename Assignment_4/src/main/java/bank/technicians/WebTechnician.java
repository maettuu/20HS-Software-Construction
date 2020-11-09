package bank.technicians;

import java.util.concurrent.TimeUnit;

public class WebTechnician implements Technician {
    public void fix() throws InterruptedException {
        TimeUnit.SECONDS.sleep(30);
        System.out.println("reparations complete");
    }
}
