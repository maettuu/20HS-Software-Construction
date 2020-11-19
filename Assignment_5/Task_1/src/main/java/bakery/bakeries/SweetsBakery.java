package bakery.bakeries;

import bakery.bakeries.food.SweetsFoodFactory;

import java.util.Arrays;
import java.util.HashMap;

public class SweetsBakery extends Bakery{
    public SweetsBakery(String name, HashMap<String, String> address){
        super(name, address);
        this.factories.add(new SweetsFoodFactory());
    }
}
