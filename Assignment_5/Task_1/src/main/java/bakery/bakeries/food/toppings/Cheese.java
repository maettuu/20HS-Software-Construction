package bakery.bakeries.food.toppings;

import bakery.bakeries.food.Food;

/**
 * A cheese topping.
 */
public class Cheese extends Topping {
    /**
     *
     * @param food the Food object it should 'top'
     */
    public Cheese(Food food){
        super(food);
    }

    /**
     *
     * @return the added cost of the base product and this product.
     */
    @Override
    public double cost() {
        return food.cost() + 1;
    }
}
