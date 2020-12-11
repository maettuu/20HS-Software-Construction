package company.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class Employee {
    @Getter String name;
    @Getter String surname;
    @Getter @Setter String address;
    @Getter @Setter String phone;

    @Getter @Setter String id;

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
