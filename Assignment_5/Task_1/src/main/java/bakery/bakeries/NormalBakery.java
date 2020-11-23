package bakery.bakeries;

import bakery.bakeries.food.factories.BreadFoodFactory;
import bakery.bakeries.food.factories.SweetsFoodFactory;

import java.util.HashMap;

/**
 * A NormalBakery can sell Sweets and Bread.
 */
public class NormalBakery extends Bakery {
    /**
     * The relevant factories are added in the constructor.
     * @param name      The name of the bakery.
     * @param address   The address of the bakery.
     */
    public NormalBakery(String name, HashMap<String, String> address){
        super(name, address);
        this.factories.add(new SweetsFoodFactory());
        this.factories.add(new BreadFoodFactory());
    }
}
