package bakery.offices;

import bakery.BakeryComponent;

public class CentralOffice extends Office {
    private static CentralOffice instance;

    private CentralOffice(){
        super("");
    }

    public static CentralOffice getInstance(){
        if(instance == null){
            instance = new CentralOffice();
        }
        return instance;
    }

    public void printAllOffices(){
        for(BakeryComponent child : this.children){
            child.printAllChildrenNames();
        }
    };

    @Override
    public void printName() {}
}
