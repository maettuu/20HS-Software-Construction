package bakery.bakeries.food.toppings;

import bakery.bakeries.food.Food;

/**
 * A Cream topping.
 */
public class Cream extends Topping{
    /**
     *
     * @param food The base food this topping is decorating.
     */
    public Cream(Food food){
        super(food);
    }

    /**
     *
     * @return the added cost of the base product and this product.
     */
    @Override
    public double cost() {
        return food.cost() + 1.5;
    }
}
