package bakery.bakeries.food.toppings;


import bakery.bakeries.food.Food;

/**
 * A Topping is a type of food which can only exist with another type of food.
 */
public abstract class Topping implements Food {
    protected Food food;

    /**
     *
     * @param food The base food this topping is decorating.
     */
    public Topping(Food food){
        this.food = food;
    }

    /**
     *
     * @return the added cost of the base product and this product.
     */
    @Override
    public abstract double cost();
}
