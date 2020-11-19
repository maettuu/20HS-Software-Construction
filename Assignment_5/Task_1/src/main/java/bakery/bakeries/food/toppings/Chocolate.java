package bakery.bakeries.food.toppings;

import bakery.bakeries.food.Food;

public class Chocolate extends Topping {

    public Chocolate(Food f){
        super(f);
    }

    @Override
    public double cost() {
        return f.cost() + 2;
    }
}
