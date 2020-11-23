package bakery.bakeries.food;

/**
 * A Food is an interface which all specific types of food (Sandwich, Cake) and all possible toppings (Cream, Cheese) implement.
 */
public interface Food {
    /**
     * @return the cost of a certain Food item.
     */
    public double cost();
}
