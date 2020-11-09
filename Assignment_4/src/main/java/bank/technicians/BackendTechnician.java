package bank.technicians;

import bank.Person;

public class BackendTechnician extends Person implements Technician {

    public BackendTechnician(String name, String surname){
        super(name, surname);
    }

    public void fix(int technicianId){
        System.out.println("fixed!");
    }
}
