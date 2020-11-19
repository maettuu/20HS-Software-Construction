package bakery.offices;

import bakery.bakeries.Bakery;
import bakery.BakeryComponent;

import java.util.ArrayList;

public abstract class Office implements BakeryComponent {
    protected String name;
    protected ArrayList<BakeryComponent> children;

    public Office(String name){
        this.children = new ArrayList<>();
        this.name = name;
    }

    public void addBakery(BakeryComponent b){
        this.children.add(b);
    }

    public void removeBakery(BakeryComponent b){
        int idx = this.children.indexOf(b);
        if (idx != -1) {
          this.children.remove(idx);
        }
    }

    @Override
    public abstract void printName();

    @Override
    public void printAllChildrenNames() {
        this.printName();
        for(BakeryComponent child : this.children){
            child.printAllChildrenNames();
        }
    }

}
