package bakery.offices;

import bakery.BakeryComponent;

import java.util.ArrayList;

/**
 * This is an abstract class which all offices extend.
 */
public abstract class Office implements BakeryComponent {
    protected String name;
    protected ArrayList<BakeryComponent> children;
    protected BakeryComponent parent;

    /**
     *
     * @param name the name of the office.
     */
    public Office(String name){
        this.children = new ArrayList<>();
        this.name = name;
    }

    /**
     * Adds a child component to this office if it doesn't have another office as parent yet.
     * @param child the child component being added
     */
    @Override
    public void addChild(BakeryComponent child){
        if(child.hasParent()){
            System.out.println("Another office is responsible for this bakery!");
            return;
        }
        child.setParent(this);
        this.children.add(child);
    }

    /**
     * Removes a child component if it actually is a child component.
     * @param name
     */
    @Override
    public void removeChild(String name){
        BakeryComponent b = this.getChild(name);
        if(b == null){return;}
        int idx = this.children.indexOf(b);
        if (idx != -1) {
          this.children.remove(idx);
        }
    }

    /**
     * Returns a child component by its name
     * @param name  the name of the child component.
     * @return      the child component if exists, otherwise null.
     */
    @Override
    public BakeryComponent getChild(String name){
        for(BakeryComponent child: children){
            if (child.getName() == name){
                return child;
            }
        }
        return null;
    }

    /**
     * Method for printing the name of an office.
     */
    @Override
    public abstract void printName();

    /**
     * Prints recursively the names of all child components.
     */
    @Override
    public void printAllChildrenNames() {
        this.printName();
        for(BakeryComponent child : this.children){
            child.printAllChildrenNames();
        }
    }

    /**
     *
     * @return the name of this office.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Sets a parent if none exists.
     * @param parent the new parent
     */
    @Override
    public void setParent(BakeryComponent parent) {
        if(this.hasParent()){
            throw new AssertionError("This Office alredy has a parent!");
        }
        this.parent = parent;
    }

    /**
     * Returns if this office has a parent.
     * @return
     */
    @Override
    public boolean hasParent() {
        return this.parent != null;
    }

    /**
     * Removes the parent of this office.
     */
    @Override
    public void removeParent() {
        this.parent = null;
    }

    /**
     *
     * @return the parent
     */
    public BakeryComponent getParent(){
        return this.parent;
    }
}
