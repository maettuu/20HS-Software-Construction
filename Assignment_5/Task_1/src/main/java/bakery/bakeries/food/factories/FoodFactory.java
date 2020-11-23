package bakery.bakeries.food.factories;

import bakery.bakeries.food.Food;
import bakery.exceptions.InvalidOrderException;

/**
 * An interface for a food factory which creates meals
 */
public interface FoodFactory {
    /**
     *
     * @param mealName  The name of the base meal (can't be a topping)
     * @param toppings  A list of all topping names we want to add
     * @return          The new food with all the toppings on top
     */
    public Food createMeal(String mealName, String[] toppings) throws InvalidOrderException;
    }
