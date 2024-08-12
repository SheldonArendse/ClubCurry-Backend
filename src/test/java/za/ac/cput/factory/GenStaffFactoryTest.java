package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.GeneralStaff;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GenStaffFactoryTest {

    @Test
    @Order(1)
    void buildGenStaff() {
        GeneralStaff generalStaff = GenStaffFactory.buildGenStaff("1234567890127","Mo", "Zouheir", "momo", "Kl$dfmnjsjeS12");
        assertNotNull(generalStaff);

    }
    @Test
    @Order(2)
    void buildGenStaffFail() {
        GeneralStaff generalStaff = GenStaffFactory.buildGenStaff("mvm","Mo", "Zouheir", "momo", "password");
        assertNull(generalStaff);

    }
}