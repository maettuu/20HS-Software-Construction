package bakery.bakeries.food.factories;

import bakery.bakeries.food.Food;
import bakery.bakeries.food.Sandwich;
import bakery.bakeries.food.toppings.Cheese;
import bakery.bakeries.food.toppings.Ham;
import bakery.bakeries.food.toppings.Tomatoes;
import bakery.bakeries.food.toppings.Tuna;
import bakery.exceptions.InvalidOrderException;

public class BreadFoodFactory implements FoodFactory {
    public Food addTopping(Food f, String toppingName) throws InvalidOrderException {
        switch (toppingName){
            case "Ham":
                return new Ham(f);
            case "Tomatoes":
                return new Tomatoes(f);
            case "Cheese":
                return new Cheese(f);
            case "Tuna":
                return new Tuna(f);
            default:
                return null;
        }

    }
    public Food createMeal(String mealName, String toppings[]) throws InvalidOrderException {
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
