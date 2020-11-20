package bakery.bakeries;

import bakery.BakeryComponent;
import bakery.bakeries.food.Food;
import bakery.bakeries.food.factories.FoodFactory;
import bakery.exceptions.InvalidOrderException;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Bakery implements BakeryComponent {
    protected String name;
    protected HashMap<String, String> address;
    protected ArrayList<FoodFactory> factories;
    protected BakeryComponent parent;

    public Bakery(String name, HashMap<String, String> address){
        this.name = name;
        this.address = address;
        this.factories = new ArrayList<>();
    }

    public Food orderMeal(String foodName, String[] toppings) throws InvalidOrderException {
        for(FoodFactory factory: factories){
            Food meal = factory.createMeal(foodName, toppings);
            if (meal != null){return meal;}
        }
        throw new InvalidOrderException();
    }

    public Food orderMeal(String foodName) throws InvalidOrderException {
        String[] toppings = {};
        for(FoodFactory factory: factories){
            Food meal = factory.createMeal(foodName, toppings);
            if (meal != null){return meal;}
        }
        throw new InvalidOrderException();
    }

    @Override
    public void printName(){
        System.out.print(this.name + ", ");
    }

    @Override
    public void printAllChildrenNames() {
        this.printName();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public BakeryComponent getChild(String name) {
        return null;
    }

    @Override
    public void addChild(BakeryComponent child) {
        throw new AssertionError("A bakery can't have children!");
    }

    @Override
    public void removeChild(String name) {
        throw new AssertionError("A bakery doesn't have children!");
    }

    @Override
    public void setParent(BakeryComponent parent){
        if(this.parent != null){
            throw new AssertionError("Parent already exists!");
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
