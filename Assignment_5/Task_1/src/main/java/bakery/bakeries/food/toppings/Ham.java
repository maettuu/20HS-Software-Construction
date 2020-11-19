package bakery.bakeries.food.toppings;

import bakery.bakeries.food.Food;

public class Ham extends Topping {

    public Ham(Food f){
        super(f);
    }

    @Override
    public double cost() {
        return f.cost() + 2;
    }
}
