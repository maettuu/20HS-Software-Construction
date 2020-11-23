package bakery.bakeries;

import bakery.BakeryComponent;
import bakery.bakeries.food.Food;
import bakery.bakeries.food.factories.FoodFactory;
import bakery.exceptions.InvalidOrderException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Bakery is an abstract class which all concrete bakeries implement. It stores all the functionality but the bakeries themselves have the reference to the recipes.
 * Since a Bakery doesn't have children, all child related methods return null or throw an exception.
 */
public abstract class Bakery implements BakeryComponent {
    protected String name;
    protected HashMap<String, String> address;
    protected ArrayList<FoodFactory> factories;
    protected BakeryComponent parent;

    /**
     *
     * @param name      The name of the bakery.
     * @param address   A HashMap which stores the address in this way ("Street", "[Actual street name]")
     */
    public Bakery(String name, HashMap<String, String> address){
        this.name = name;
        this.address = address;
        this.factories = new ArrayList<>();
    }

    /**
     * Orders and creates a meal with toppings.
     * @param foodName                  The name of the meal being ordered.
     * @param toppings                  A list of the string topping names.
     * @return                          The meal ordered.
     * @throws InvalidOrderException    Thrown when an item ordered can't be delivered a this bakery.
     */
    public Food orderMeal(String foodName, String[] toppings) throws InvalidOrderException {
        for(FoodFactory factory: factories){
            Food meal = factory.createMeal(foodName, toppings);
            if (meal != null){return meal;}
        }
        throw new InvalidOrderException();
    }

    /**
     * Orders and creates a meal without toppings. This method exists so the caller doesn't have to
     * supply an empty list if no toppings are requested.
     * @param foodName                  The name of the meal being ordered.
     * @return                          The meal ordered.
     * @throws InvalidOrderException    Thrown when an item ordered can't be delivered a this bakery.
     */
    public Food orderMeal(String foodName) throws InvalidOrderException {
        String[] toppings = {};
        return this.orderMeal(foodName, toppings);
    }

    /**
     * Prints the name of a bakery with a comma at the end.
     */
    @Override
    public void printName(){
        System.out.print(this.name + ", ");
    }

    /**
     * Only calls printName as a bakery doesn't have children.
     */
    @Override
    public void printAllChildrenNames() {
        this.printName();
    }

    /**
     *
     * @return name of this bakery.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     *
     * @param name  the name of the child component.
     * @return null, as there are no children in bakeries.
     */
    @Override
    public BakeryComponent getChild(String name) {
        return null;
    }

    /**
     * Throws an error as a bakery can't have children!
     * @param child irrelevant
     */
    @Override
    public void addChild(BakeryComponent child) {
        throw new AssertionError("A bakery can't have children!");
    }

    /**
     * Throws an error as a bakery can't have children!
     * @param name irrelevant
     */
    @Override
    public void removeChild(String name) {
        throw new AssertionError("A bakery doesn't have children!");
    }

    /**
     * Sets a new parent.
     * @param parent the new parent
     */
    @Override
    public void setParent(BakeryComponent parent){
        if(this.parent != null){
            throw new AssertionError("Parent already exists!");
        }
        this.parent = parent;
    }

    /**
     * Returns if a parent exists.
     * @return boolean
     */
    @Override
    public boolean hasParent() {
        return this.parent != null;
    }

    /**
     * Removes this bakeries parent.
     */
    @Override
    public void removeParent() {
        this.parent = null;
    }

    /**
     *
     * @return parent of this bakery.
     */
    public BakeryComponent getParent(){
        return this.parent;
    }
}
