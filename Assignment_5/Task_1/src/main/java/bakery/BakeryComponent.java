package bakery;

public interface BakeryComponent {
    public BakeryComponent getChild(String name);
    public void addChild(BakeryComponent child);
    public void removeChild(String name);

    public void printName();
    public void printAllChildrenNames();
    public String getName();

    public void setParent(BakeryComponent parent);
    public boolean hasParent();
}
