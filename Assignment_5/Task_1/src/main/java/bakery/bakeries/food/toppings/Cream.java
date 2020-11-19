package bakery.bakeries.food.toppings;

import bakery.bakeries.food.Food;

public class Cream extends Topping{

    public Cream(Food f){
        super(f);
    }

    @Override
    public double cost() {
        return f.cost() + 1.5;
    }
}
