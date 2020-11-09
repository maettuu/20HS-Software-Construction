package bank;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class Person {
    protected String name;
    protected String surname;
    protected UUID id;

    public Person(String name, String surname){
        this.name = name;
        this.surname = surname;
        this.id = UUID.randomUUID();
    }
}
