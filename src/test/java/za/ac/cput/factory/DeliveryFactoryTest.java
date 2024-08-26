package za.ac.cput.factory;

import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DeliveryFactoryTest {
    @Test
    void testBuildDelivery_Passing() {
        boolean delivered = true;
        Date completed = new Date(System.currentTimeMillis());
        Driver driver = mock(Driver.class);
        Orders order = mock(Orders.class);
        Address address = mock(Address.class);

        Delivery delivery = DeliveryFactory.buildDelivery(delivered, completed, driver, order, address);

        assertNotNull(delivery);
        assertEquals(delivered, delivery.isDelivered());
        assertEquals(completed, delivery.getCompleted());
        assertEquals(driver, delivery.getDriver());
        assertEquals(order, delivery.getOrder());
        assertEquals(address, delivery.getAddress());
    }

    @Test
    void testBuildDelivery_Failing() {
        boolean delivered = true;
        Date completed = new Date(System.currentTimeMillis());
        Driver driver = null;
        Orders order = null;
        Address address = null;

        Delivery delivery = DeliveryFactory.buildDelivery(delivered, completed, driver, order, address);

        assertNull(delivery);
    }

}