package bakery.offices;

public class CityOffice extends Office {

    public CityOffice(String name) {
        super(name);
    }

    @Override
    public void printName() {
        System.out.print("city office of " + this.name + ", ");
    }

}
