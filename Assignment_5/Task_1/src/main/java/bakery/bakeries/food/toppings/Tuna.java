package bakery.bakeries.food.toppings;

import bakery.bakeries.food.Food;

public class Tuna extends Topping {

    public Tuna(Food f){
        super(f);
    }

    @Override
    public double cost() {
        return f.cost() + 3;
    }
}
