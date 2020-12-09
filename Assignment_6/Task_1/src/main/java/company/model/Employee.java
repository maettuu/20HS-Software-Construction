package company.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class Employee {
    @Getter @Setter String name;
    @Getter @Setter String surname;
    @Getter @Setter String address;
    @Getter @Setter int phone;

    @Getter UUID id;

    public Employee(String name, String surname, String address, int phone){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;

        this.id = UUID.randomUUID();
    }
}
