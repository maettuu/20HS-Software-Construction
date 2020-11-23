package bakery;

/**
 * This interface is used for the composite design pattern. Nodes and leafs have to implement it.
 */
public interface BakeryComponent {

    /**
     * Returns a child component given its name if it exists.
     * @param name  the name of the child component.
     * @return the child component
     */
    public BakeryComponent getChild(String name);

    /**
     * Adds a component as a child. Should only work if the child doesn't have a parent yet.
     * @param child the components which is being added.
     */
    public void addChild(BakeryComponent child);

    /**
     * Removes a child component if existing.
     * @param name
     */
    public void removeChild(String name);

    /**
     * Prints out the name of the component.
     */
    public void printName();

    /**
     * This method is meant for recursively printing out the names of all child components and the child components of those components.
     */
    public void printAllChildrenNames();

    /**
     *
     * @return  the name of this component
     */
    public String getName();

    /**
     * Sets a parent if no parent has been defined yet.
     * @param parent the new parent
     */
    public void setParent(BakeryComponent parent);

    /**
     * Returns if a component has already a parent.
     * @return true if parent exists, false otherwise
     */
    public boolean hasParent();

    /**
     * Removes the parent if it exists.
     */
    public void removeParent();

}
