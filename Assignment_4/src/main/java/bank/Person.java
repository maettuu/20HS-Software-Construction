package bank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Person {
    protected String name;
    protected String surname;
    protected int id;

    public Person(String name, String surname, int id){
        this.name = name;
        this.surname = surname;
        this.id = id;
    }
}
