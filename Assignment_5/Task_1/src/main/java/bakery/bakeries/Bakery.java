package bakery.bakeries;

import bakery.BakeryComponent;
import bakery.bakeries.food.Food;
import bakery.bakeries.food.FoodFactory;
import bakery.exceptions.InvalidOrderException;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Bakery implements BakeryComponent {
    protected String name;
    protected HashMap<String, String> address;
    protected ArrayList<FoodFactory> factories;

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

    public void printName(){
        System.out.print(this.name + ", ");
    }

    @Override
    public void printAllChildrenNames() {
        this.printName();
    }
}
