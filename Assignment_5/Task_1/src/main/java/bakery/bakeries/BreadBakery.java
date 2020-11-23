package bakery.bakeries;

import bakery.bakeries.food.factories.BreadFoodFactory;

import java.util.HashMap;

/**
 * A BreadBakery can only sell bread.
 */
public class BreadBakery extends Bakery{
    /**
     * The relevant factories are added in the constructor.
     * @param name      The name of the bakery.
     * @param address   The address of the bakery.
     */
    public BreadBakery(String name, HashMap<String, String> address){
        super(name, address);
        this.factories.add(new BreadFoodFactory());
    }
}
