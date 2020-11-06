package bank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Person {
    private String name;
    private String surname;
    private int id;
}
