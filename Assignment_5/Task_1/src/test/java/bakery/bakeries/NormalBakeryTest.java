package bakery.bakeries;

import bakery.bakeries.food.Food;
import bakery.exceptions.InvalidOrderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class NormalBakeryTest {
    Bakery normal;
    Food sandwich;
    Food cake;
    String[] toppings;

    @BeforeEach
    void setUp() throws InvalidOrderException {
        normal = new NormalBakery("normal", new HashMap<String, String>());
        cake = normal.orderMeal("Cake");
        sandwich = normal.orderMeal("Sandwich");
        toppings = new String[]{"Chocolate"};
    }


    @Test
    void testOrderMeal(){
        assertEquals(3, cake.cost());
    }

    @Test
    void testAddTopping() throws InvalidOrderException {
        String[] toppings = {"Chocolate"};
        Food chocoCake = normal.orderMeal("Cake", toppings);
        assertEquals(5, chocoCake.cost());
    }

    @Test
    void testWrongTopping(){
        assertThrows(InvalidOrderException.class, () -> {
            normal.orderMeal("Sandwich", new String[]{"Chocolate"});
        });
    }

    @Test
    void testWrongFood(){
        assertThrows(InvalidOrderException.class, () -> {
            normal.orderMeal("Bla");
        });
    }

    @Test
    void testCostMultipleToppings() throws InvalidOrderException {
        Food f = normal.orderMeal("Cake", new String[]{"Chocolate", "Cream", "Chocolate"});
        assertEquals(8.5, f.cost());
    }

    @Test
    void testMultipleToppingsWrongTopping(){
        assertThrows(InvalidOrderException.class, () -> {
           normal.orderMeal("Cake", new String[]{"Chocolate", "Cream", "Ham"});
        });
    }

}