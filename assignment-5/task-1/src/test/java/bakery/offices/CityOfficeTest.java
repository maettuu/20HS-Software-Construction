package bakery.offices;

import bakery.BakeryComponent;
import bakery.bakeries.Bakery;
import bakery.bakeries.BreadBakery;
import bakery.bakeries.SweetsBakery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CityOfficeTest {
    CityOffice c;
    CityOffice c2;
    Bakery bread;
    Bakery sweets;


    @BeforeEach
    void setUp() {
        c = new CityOffice("Some Office");
        c2 = new CityOffice("Other Office");
        bread = new BreadBakery("Bready", new HashMap<String, String>());
        sweets = new SweetsBakery("Sweety", new HashMap<String, String>());
    }

    @Test
    void getAddBakery(){
        c.addChild(bread);
        c.addChild(sweets);
        BakeryComponent returnValue = c.getChild("Bready");;
        assertEquals("Bready", returnValue.getName());
    }

    @Test
    void getNonexistentBakery(){
        c.addChild(bread);
        c.addChild(sweets);
        BakeryComponent returnValue = c.getChild("Bla");
        assertEquals(null, returnValue);
    }

    @Test
    void addingBakeryToTwoOffices(){
        c.addChild(bread);
        c2.addChild(bread);
        BakeryComponent parent = bread.getParent();
        assertEquals(parent.getName(), "Some Office");
    }
}