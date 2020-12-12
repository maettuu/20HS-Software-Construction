package company.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class Employee {
    @Getter private String name;
    @Getter private String surname;
    @Getter @Setter private String address;
    @Getter @Setter private String phone;

    @Getter @Setter private String id;

    public Employee(String name, String surname, String address, String phone){
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", id='" + id + '\'';
    }
}
