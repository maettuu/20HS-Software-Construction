package bakery.bakeries.food.toppings;

import bakery.bakeries.food.Food;

public class Cheese extends Topping {

    public Cheese(Food f){
        super(f);
    }

    @Override
    public double cost() {
        return f.cost() + 1;
    }
}
