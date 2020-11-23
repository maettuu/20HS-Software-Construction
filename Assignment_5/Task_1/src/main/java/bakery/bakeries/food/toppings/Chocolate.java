package bakery.bakeries.food.toppings;

import bakery.bakeries.food.Food;

/**
 * A Chocolate topping.
 */
public class Chocolate extends Topping {
    /**
     *
     * @param food The base food this topping is decorating.
     */
    public Chocolate(Food food){
        super(food);
    }

    /**
     *
     * @return the added cost of the base product and this product.
     */
    @Override
    public double cost() {
        return food.cost() + 2;
    }
}
