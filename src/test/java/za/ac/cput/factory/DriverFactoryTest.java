package za.ac.cput.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DriverFactoryTest {
    @Test
    void testBuildDriverWithPetrolAllowance_Passing() {
        String id = "1234567890123";
        double petrolAllowance = 500.0;
        Vehicle registration = mock(Vehicle.class);
        String name = "John";
        String surname = "Doe";
        String password = "Kl$dfmnjsjeS12";
        String username = "john.doe";

        Driver driver = DriverFactory.buildDriver(id, petrolAllowance, registration, name, surname, password, username);
        assertNotNull(driver);
        assertEquals(id, driver.getId());
        assertEquals(petrolAllowance, driver.getPetrolAllowance());
        assertEquals(registration, driver.getRegistration());
        assertEquals(name, driver.getName());
        assertEquals(surname, driver.getSurname());
        assertEquals(password, driver.getPassword());
        assertEquals(username, driver.getUsername());
    }

    @Test
    void testBuildDriverWithPetrolAllowance_Failing() {
        String id = "invalid_id";
        double petrolAllowance = 500.0;
        Vehicle registration = mock(Vehicle.class);
        String name = "John";
        String surname = "Doe";
        String password = "Password123";
        String username = "john.doe";


        Driver driver = DriverFactory.buildDriver(id, petrolAllowance, registration, name, surname, password, username);

        assertNull(driver);
    }

}