package bakery.bakeries;

import bakery.bakeries.food.BreadFoodFactory;
import bakery.bakeries.food.Food;
import bakery.bakeries.food.FoodFactory;
import bakery.exceptions.InvalidOrderException;

import java.util.Arrays;
import java.util.HashMap;

public class BreadBakery extends Bakery{
    public BreadBakery(String name, HashMap<String, String> address){
        super(name, address);
        this.factories.add(new BreadFoodFactory());
    }
}
