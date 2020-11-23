package bakery.bakeries.food.toppings;

import bakery.bakeries.food.Food;

public class Ham extends Topping {
    /**
     *
     * @param food The base food this topping is decorating.
     */
    public Ham(Food food){
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
