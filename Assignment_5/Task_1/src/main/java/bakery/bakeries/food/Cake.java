package bakery.bakeries.food;

/**
 * A Cake is a type of food with a certain price.
 */
public class Cake implements Food {
    /**
     *
     * @return  the price of this product.
     */
    @Override
    public double cost() {
        return 3;
    }
}
