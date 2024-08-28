package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.Driver;
import za.ac.cput.domain.Orders;
import za.ac.cput.domain.enums.DeliveryStatus;

import java.sql.Date;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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

        Delivery delivery = DeliveryFactory.buildDelivery(delivered,completed,driver,order, address,LocalTime.now(), DeliveryStatus.PENDING,LocalTime.now().minusHours(1L));

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

        Delivery delivery = DeliveryFactory.buildDelivery(delivered,completed,driver,order, address,LocalTime.now(), DeliveryStatus.PENDING,LocalTime.now().minusHours(1L));

        assertNull(delivery);
    }

}