package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Menu;

import static org.junit.jupiter.api.Assertions.*;

class MenuFactoryTest {

    @Test
    // to test creation of new menu.
    void buildMenu() {
        Menu createdObj = MenuFactory.buildMenu("Starters");
        assertNotNull(createdObj);
        System.out.println(createdObj);
    }

    @Test
    void testBuildMenu() {
        // to test update method
        Menu createdObj = MenuFactory.buildMenu(5L,"Mains");
        assertNotNull(createdObj);
        System.out.println(createdObj);
    }
    @Test
    void buildMenufail() {
        // to test fail
        Menu createdObj = MenuFactory.buildMenu("");
        assertNull(createdObj);
        System.out.println(createdObj);
    }

    @Test
    void testBuildMenufail() {
        //to test fail
        Menu createdObj = MenuFactory.buildMenu(1L,"");
        assertNull(createdObj);
        System.out.println(createdObj);
    }
}