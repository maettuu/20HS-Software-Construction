package bakery.offices;

import bakery.bakeries.BreadBakery;
import bakery.bakeries.NormalBakery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class CentralOfficeTest {
    CentralOffice cent;
    CityOffice city;
    CityOffice city2;
    NormalBakery norm;
    BreadBakery bread;

    @BeforeEach
    void setUp() {
        cent = CentralOffice.getInstance();

        city = new CityOffice("Münsterlingen");
        city2 = new CityOffice("Frauenfeld");

        HashMap<String, String> normal_addr = new HashMap<>();
        normal_addr.put("street", "some normal street");
        normal_addr.put("city", "some normal city");

        HashMap<String, String> bread_addr = new HashMap<>();
        bread_addr.put("street", "some bread street");
        bread_addr.put("city", "some bread city");

        norm = new NormalBakery("SomeNormalBakery", normal_addr);
        bread = new BreadBakery("SomeBreadBakery", bread_addr);

    }

    @Test
    void testPrint(){
        cent.addChild(city);
        cent.addChild(city2);
        city.addChild(norm);
        city.addChild(bread);
        cent.printAllOffices();
    }
}