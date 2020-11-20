package bakery.bakeries;

import bakery.bakeries.food.factories.BreadFoodFactory;

import java.util.HashMap;

public class BreadBakery extends Bakery{
    public BreadBakery(String name, HashMap<String, String> address){
        super(name, address);
        this.factories.add(new BreadFoodFactory());
    }
}
