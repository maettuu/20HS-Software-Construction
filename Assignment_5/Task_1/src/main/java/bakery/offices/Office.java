package bakery.offices;

import bakery.BakeryComponent;

import java.util.ArrayList;

public abstract class Office implements BakeryComponent {
    protected String name;
    protected ArrayList<BakeryComponent> children;
    protected BakeryComponent parent;

    public Office(String name){
        this.children = new ArrayList<>();
        this.name = name;
    }

    @Override
    public void addChild(BakeryComponent b){
        if(b.hasParent()){
            System.out.println("Another office is responsible for this bakery!");
            return;
        }
        b.setParent(this);
        this.children.add(b);
    }

    @Override
    public void removeChild(String name){
        BakeryComponent b = this.getChild(name);
        if(b == null){return;}
        int idx = this.children.indexOf(b);
        if (idx != -1) {
          this.children.remove(idx);
        }
    }
    @Override
    public BakeryComponent getChild(String name){
        for(BakeryComponent child: children){
            if (child.getName() == name){
                return child;
            }
        }
        return null;
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

    @Override
    public String getName() {
        return this.name;
    }


    @Override
    public void setParent(BakeryComponent parent) {
        if(this.hasParent()){
            throw new AssertionError("This Office alredy has a parent!");
        }
        this.parent = parent;
    }

    @Override
    public boolean hasParent() {
        return this.parent != null;
    }

    public BakeryComponent getParent(){
        return this.parent;
    }
}
