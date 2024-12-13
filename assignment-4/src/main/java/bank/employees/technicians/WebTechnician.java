package bank.employees.technicians;

import bank.Person;

import java.util.concurrent.TimeUnit;

public class WebTechnician extends Person implements Technician {
    public WebTechnician(String name, String surname){
        super(name, surname);
    }

    public void fix() throws InterruptedException {
        TimeUnit.SECONDS.sleep(30);
        System.out.println("reparations complete");
    }
}
