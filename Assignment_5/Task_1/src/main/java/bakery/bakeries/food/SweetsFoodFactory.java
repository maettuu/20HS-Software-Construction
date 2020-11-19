package bakery.bakeries.food;

import bakery.bakeries.food.toppings.*;
import bakery.exceptions.InvalidOrderException;

public class SweetsFoodFactory implements FoodFactory{
    public Food addTopping(Food f, String toppingName) {
        switch (toppingName){
            case "Strawberries":
                return new Strawberries(f);
            case "Chocolate":
                return new Chocolate(f);
            case "Cream":
                return new Cream(f);
            default:
                return null;
        }

    }
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
