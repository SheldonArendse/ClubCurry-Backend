package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerFactoryTest {

    @Test
    void buildCustomer() {
        Customer c1 = CustomerFactory.buildCustomer("logancoghill18@gmail.com", "Logan", "Coghill","0875632598","Th#s1sATest");
        assertNotNull(c1);
        System.out.println(c1);
    }

    @Test
    void buildCustomerWithAddresses() {
        Address a1 = AddressFactory.buildAddress("fake Street", "23","belhar",7494);
        List<Address> listA = new ArrayList<>();
        listA.add(a1);
        Customer c1 = CustomerFactory.buildCustomer("logancoghill18@gmail.com", "Logan", "Coghill","0875632598","Th#s1sATest", listA);
        assertNotNull(c1);
        System.out.println(c1);
    }

    @Test
    void buildCustomerFail(){
        Customer c1 = CustomerFactory.buildCustomer("logancoghill18", "Logan", "Coghill","0875632598","Th#s1sATest");
        assertNull(c1);
        System.out.println("invalid Email");
    }
}