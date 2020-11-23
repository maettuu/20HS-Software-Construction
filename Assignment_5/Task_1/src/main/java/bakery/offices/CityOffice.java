package bakery.offices;

/**
 * A city office works the same way as an Office.
 * @see bakery.offices.Office
 */
public class CityOffice extends Office {
    /**
     *
     * @param name the name of the office
     */
    public CityOffice(String name) {
        super(name);
    }

    /**
     * Prints the name of this office with a ' ,' at the end.
     */
    @Override
    public void printName() {
        System.out.print("city office of " + this.name + ", ");
    }

}
