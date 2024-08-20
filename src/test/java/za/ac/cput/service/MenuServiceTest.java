package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Ingredient;
import za.ac.cput.domain.Menu;
import za.ac.cput.factory.MenuFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

class MenuServiceTest {

    @Autowired
    private MenuService menuService;

    private static Menu menu1, menu2;

    @BeforeEach
    void a_setUp() {
        menu1 = MenuFactory.buildMenu(5L, "Prawn Curry");
        assertNotNull(menu1);
        System.out.println(menu1);

        menu2 = MenuFactory.buildMenu(9L, "Chicken Curry");
        assertNotNull(menu2);
        System.out.println(menu2);
    }

    @Test
    void b_save() {
        Menu savedMenu1 = menuService.save(menu1);
        assertNotNull(savedMenu1);
        System.out.println(savedMenu1);

        Menu savedMenu2 = menuService.save(menu2);
        assertNotNull(savedMenu2);
        System.out.println(savedMenu2);
    }

    @Test
    void c_read() {
        Menu read = menuService.read(2L);
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Menu newMenu = new Menu.Builder().copy(menu2).setName("Beef Curry").setId(2L).build();
        Menu updated = menuService.update(newMenu);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void f_delete() {
        menuService.delete(menu1.getId());
        System.out.println("menu1 successfully deleted");
    }

    @Test
    void e_getAll() {
        System.out.println(menuService.getAll());
    }
}