package bakery.bakeries.food.factories;

import bakery.bakeries.food.Food;
import bakery.bakeries.food.Sandwich;
import bakery.bakeries.food.toppings.Cheese;
import bakery.bakeries.food.toppings.Ham;
import bakery.bakeries.food.toppings.Tomatoes;
import bakery.bakeries.food.toppings.Tuna;
import bakery.exceptions.InvalidOrderException;

/**
 * A Factory which only bakes bread and adds possible toppings.
 */
public class BreadFoodFactory implements FoodFactory {
    /**
     *
     * @param food          The food which we want to add a topping to
     * @param toppingName   The name of said topping
     * @return              The new food with the topping on top or null if food like that doesn't exist
     */
    private Food addTopping(Food food, String toppingName) {
        switch (toppingName){
            case "Ham":
                return new Ham(food);
            case "Tomatoes":
                return new Tomatoes(food);
            case "Cheese":
                return new Cheese(food);
            case "Tuna":
                return new Tuna(food);
            default:
                return null;
        }

    }

    /**
     *
     * @param mealName  The name of the base meal (can't be a topping)
     * @param toppings  A list of all topping names we want to add
     * @return          The new food with all the toppings on top
     */
    public Food createMeal(String mealName, String toppings[]) {
        Food f;
        switch (mealName){
            case "Sandwich":
                f = new Sandwich();
                break;
            default:
                return null;
        }
        for(String topping: toppings){
            f = this.addTopping(f, topping);
        }
        return f;
    }
}
