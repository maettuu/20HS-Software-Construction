package bakery.offices;

public class CentralOffice extends Office {
    private static CentralOffice instance;

    private CentralOffice(){
        super("Central Office");
    }

    public static CentralOffice getInstance(){
        if(instance == null){
            instance = new CentralOffice();
        }
        return instance;
    }

    public void printAllOffices(){
        this.printAllChildrenNames();
    };

    @Override
    public void printName() {}
}
