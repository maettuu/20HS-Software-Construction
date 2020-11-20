package bakery.bakeries.food.factories;

import bakery.bakeries.food.Food;
import bakery.exceptions.InvalidOrderException;

public interface FoodFactory {
    Food addTopping(Food f, String toppingName) throws InvalidOrderException;
    public Food createMeal(String mealName, String[] toppings) throws InvalidOrderException;
    }
