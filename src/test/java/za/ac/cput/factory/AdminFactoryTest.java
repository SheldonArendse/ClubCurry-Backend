package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Admin;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AdminFactoryTest {

    @Test
    @Order(1)
    void buildAdmin() {
        Admin admin = AdminFactory.buildAdmin("1234567890127","Mo", "Zouheir", "momo", "Kl$dfmnjsjeS12");
        assertNotNull(admin);

    }
    @Test
    @Order(2)
    void buildAdminFail() {
        Admin admin = AdminFactory.buildAdmin("mvm","Mo", "Zouheir", "momo", "password");
        assertNull(admin);

    }

}