package bakery.bakeries;

import bakery.bakeries.food.factories.BreadFoodFactory;
import bakery.bakeries.food.factories.SweetsFoodFactory;

import java.util.HashMap;

public class NormalBakery extends Bakery {
    public NormalBakery(String name, HashMap<String, String> address){
        super(name, address);
        this.factories.add(new SweetsFoodFactory());
        this.factories.add(new BreadFoodFactory());
    }
}
