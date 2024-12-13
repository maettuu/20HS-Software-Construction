package bakery.bakeries;

import bakery.bakeries.food.Food;
import bakery.exceptions.InvalidOrderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SweetsBakeryTest {
    SweetsBakery sweet;
    Food cake;

    @BeforeEach
    void setUp() throws InvalidOrderException {
        sweet = new SweetsBakery("name", new HashMap<String, String>());
        cake = sweet.orderMeal("Cake");
    }

    @Test
    void testOrderMeal(){
        assertEquals(3, cake.cost());
    }

    @Test
    void testAddTopping() throws InvalidOrderException {
        Food chocoCake = sweet.orderMeal("Cake", new String[]{"Chocolate"});
        assertEquals(5, chocoCake.cost());
    }

    @Test
    void testWrongTopping(){
        assertThrows(InvalidOrderException.class, () -> {
           sweet.orderMeal("Cake",new String[]{"Ham"});
        });
    }

    @Test
    void testWrongFood(){
        assertThrows(InvalidOrderException.class, () -> {
           sweet.orderMeal("Sandwich");
        });
    }
}