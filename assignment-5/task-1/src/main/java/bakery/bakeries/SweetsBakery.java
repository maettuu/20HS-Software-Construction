package bakery.bakeries;

import bakery.bakeries.food.factories.SweetsFoodFactory;

import java.util.HashMap;

/**
 * A SweetsBakery can only sell sweets.
 */
public class SweetsBakery extends Bakery{
    /**
     * The relevant factories are added in the constructor.
     * @param name      The name of the bakery.
     * @param address   The address of the bakery.
     */
    public SweetsBakery(String name, HashMap<String, String> address){
        super(name, address);
        this.factories.add(new SweetsFoodFactory());
    }
}
