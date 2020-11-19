package bakery.bakeries.food.toppings;


import bakery.bakeries.food.Food;

public abstract class Topping implements Food {
    protected Food f;

    public Topping(Food f){
        this.f = f;
    }

    @Override
    public abstract double cost();
}
