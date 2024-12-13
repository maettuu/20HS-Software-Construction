package bakery.bakeries.food.factories;

import bakery.bakeries.food.Cake;
import bakery.bakeries.food.Food;
import bakery.bakeries.food.factories.FoodFactory;
import bakery.bakeries.food.toppings.Chocolate;
import bakery.bakeries.food.toppings.Cream;
import bakery.bakeries.food.toppings.Strawberries;
import bakery.exceptions.InvalidOrderException;

/**
 * A Factory which only produces sweet food and adds possible toppings.
 */
public class SweetsFoodFactory implements FoodFactory {
    /**
     *
     * @param food          The food which we want to add a topping to
     * @param toppingName   The name of said topping
     * @return              The new food with the topping on top or null if food like that doesn't exist
     */
    private Food addTopping(Food food, String toppingName) {
        switch (toppingName){
            case "Strawberries":
                return new Strawberries(food);
            case "Chocolate":
                return new Chocolate(food);
            case "Cream":
                return new Cream(food);
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
    public Food createMeal(String mealName, String[] toppings) throws InvalidOrderException {
        Food f;
        switch (mealName){
            case "Cake":
                f = new Cake();
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
