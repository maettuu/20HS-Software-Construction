package bakery.bakeries.food.toppings;

import bakery.bakeries.food.Food;

public class Strawberries extends Topping{

    public Strawberries(Food f){
        super(f);
    }

    @Override
    public double cost() {
        return f.cost() + 1;
    }
}
