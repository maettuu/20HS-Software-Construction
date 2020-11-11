package bank.technicians;

import bank.Person;

import java.util.UUID;

public class BackendTechnician extends Person implements Technician {

    public BackendTechnician(String name, String surname){
        super(name, surname);
    }

    public void fix(UUID technicianId){
        System.out.println("fixed!");
    }
}
