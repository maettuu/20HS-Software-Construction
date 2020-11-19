package bakery.bakeries;

import bakery.bakeries.food.BreadFoodFactory;
import bakery.bakeries.food.Food;
import bakery.bakeries.food.SweetsFoodFactory;

import java.util.HashMap;

public class NormalBakery extends Bakery {
    public NormalBakery(String name, HashMap<String, String> address){
        super(name, address);
        this.factories.add(new SweetsFoodFactory());
        this.factories.add(new BreadFoodFactory());
    }
}
