package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CustomerFactoryTest {
    @Test
    void testBuildCustomerWithAddresses_Passing() {
        String email = "test@example.com";
        String name = "John";
        String surname = "Doe";
        String mobileNo = "0123456789";
        String password = "Kl$dfmnjsjeS12";
        List<Address> addresses = new ArrayList<Address>();
        addresses.add(mock(Address.class));

        Customer customer = CustomerFactory.buildCustomer(email, name, surname, mobileNo, password, addresses);

        assertNotNull(customer);
    }

    @Test
    void testBuildCustomerWithAddresses_Failing() {
        String email = "test@example.com";
        String name = "John";
        String surname = "Doe";
        String mobileNo = "0123456789";
        String password = "Password123";
        List<Address> addresses = new ArrayList<Address>();

        Customer customer = CustomerFactory.buildCustomer(email, name, surname, mobileNo, password, addresses);

        assertNull(customer);
    }

}