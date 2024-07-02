package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;

import static org.junit.jupiter.api.Assertions.*;

class AddressFactoryTest {

    @Test
    void buildAddress() {
        Address a1 = AddressFactory.buildAddress("Fake street", "34", "belhar", 7494, new Customer.Builder().setEmail("logancoghill18@gmail.com").build());
        assertNotNull(a1);
        System.out.println(a1);
    }

    @Test
    void buildAddressWithId() {
        Address a1 = AddressFactory.buildAddress(4L, "Fake street", "34", "belhar", 7494);
        assertNotNull(a1);
        System.out.println(a1);
    }

    @Test
    void buildAddressFail(){
        Address a1 = AddressFactory.buildAddress(4L, "Fake street", "3a", "belhar", 7494);
        assertNull(a1);
    }
}