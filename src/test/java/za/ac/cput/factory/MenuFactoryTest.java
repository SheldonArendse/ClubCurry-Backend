package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Menu;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = VehicleFactory.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class MenuFactoryTest {

    @Test
    @Order(1)
    void buildMenu() {
        Menu menu = MenuFactory.buildMenu("Chicken Curry");
        assertNotNull(menu);
        System.out.println(menu);

    }

    @Test
    @Order(2)
    void testBuildMenuFail() {
        Menu menu = MenuFactory.buildMenu("");
        assertNotNull(menu);
        System.out.println(menu);
    }

    @Test
    @Order(3)
    void buildMenuWithId(){
        Menu menu = MenuFactory.buildMenu(1234567L, "Beef Curry");
        assertNotNull(menu);
        System.out.println(menu);

    }

    @Test
    @Order(4)
    void buildMenuWithIdFail(){
        Menu menu = MenuFactory.buildMenu(-1234567L, "Beef Curry");
        assertNotNull(menu);
        System.out.println(menu);
    }
}