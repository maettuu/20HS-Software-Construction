package bakery.offices;

import bakery.BakeryComponent;

/**
 * A singleton which is on top of all other offices.
 */
public class CentralOffice extends Office {
    private static CentralOffice instance;

    /**
     * Constructor of a CentralOffice doesn't ask for a name as it doesn't have one (for whatever reason).
     * We gave it the name 'Central Office' but it doesn't do anything.
     */
    private CentralOffice(){
        super("Central Office");
    }

    /**
     *
     * @return the CentralOffice instance.
     */
    public static CentralOffice getInstance(){
        if(instance == null){
            instance = new CentralOffice();
        }
        return instance;
    }

    /**
     * This is a required method from the task description. It just calls printAllChildrenNames as it does
     * what this function is supposed to do.
     */
    public void printAllOffices(){
        this.printAllChildrenNames();
    };

    /**
     * Overridden to print nothing as it doesn't have a name
     */
    @Override
    public void printName() {}

    /**
     * @throws throws always as a CentralOffice can't have a parent.
     * @param parent irrelevant
     */
    @Override
    public void setParent(BakeryComponent parent) {
        throw new AssertionError("The Central Office can't have a parent!");
    }
}
