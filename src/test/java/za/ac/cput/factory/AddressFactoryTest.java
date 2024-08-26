package za.ac.cput.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AddressFactoryTest {

    @Test
    void testBuildAddressWithCustomer_Passing() {
        Customer customer = mock(Customer.class);
        when(customer.getEmail()).thenReturn("test@example.com");

        String streetName = "Main St";
        String streetNo = "123";
        String suburbName = "Central";
        int postalCode = 12345;


        Address address = AddressFactory.buildAddress(streetName, streetNo, suburbName, postalCode, customer);

        assertNotNull(address);
        assertEquals(streetName, address.getStreetName());
        assertEquals(streetNo, address.getStreetNo());
        assertEquals(suburbName, address.getSuburb().getSuburbName());
        assertEquals(postalCode, address.getSuburb().getPostalCode());
        assertEquals(customer, address.getCustomerId());
    }

    @Test
    void testBuildAddressWithCustomer_Failing() {
        Customer customer = mock(Customer.class);
        when(customer.getEmail()).thenReturn("test@example.com");
        String streetName = null;
        String streetNo = null;
        String suburbName = null;
        int postalCode = 12345;


        Address address = AddressFactory.buildAddress(streetName, streetNo, suburbName, postalCode, customer);

        assertNull(address);
    }
}