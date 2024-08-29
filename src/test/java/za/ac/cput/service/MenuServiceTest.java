package za.ac.cput.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Menu;
import za.ac.cput.factory.MenuFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MenuServiceTest {

    @Autowired
    private MenuService menuService;

    // for some reason the save is not setting this value for use in the read update and delete
    private static Menu fromDbSave;

    @Test
    @Order(1)
    void save() {
        Menu obj = MenuFactory.buildMenu("Test");
        fromDbSave = menuService.save(obj);
        assertEquals(obj,fromDbSave);
        System.out.println(fromDbSave);
    }

    @Test
    @Order(2)
    void read() {
        System.out.println(fromDbSave);
        Menu fromDb =menuService.read(fromDbSave.getId());
        assertNotNull(fromDb);
        System.out.println(fromDb);
    }

    @Test
    @Order(3)
    void update() {
        System.out.println(fromDbSave);
        Menu obj = MenuFactory.buildMenu(fromDbSave.getId(),"Test");
        assert obj != null;
        Menu fromDb =menuService.update(obj);
        assertNotNull(fromDb);
        System.out.println(fromDb);
    }

    @Test
    @Order(5)
    void delete() {
        assertTrue(menuService.delete(fromDbSave.getId()));
    }

    @Test
    @Order(4)
    void getAll() {
        List<Menu> menuList = menuService.getAll();
        assertNotNull(menuList);
        System.out.println(menuList);
    }
}