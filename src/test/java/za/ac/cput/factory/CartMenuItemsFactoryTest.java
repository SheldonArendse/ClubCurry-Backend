package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.MenuItem;
import za.ac.cput.domain.enums.SpiceLevel;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CartMenuItemsFactoryTest {

    @Test
    void testBuildCartMenuItem_Passing() {
        MenuItem menuItem = mock(MenuItem.class);
        when(menuItem.getId()).thenReturn(1L);

        int quantity = 5;
        String note = "Extra spicy";
        SpiceLevel spiceLevel = SpiceLevel.HIGH;

        CartMenuItems cartMenuItems = CartMenuItemsFactory.buildCartMenuItem(menuItem, quantity, note, spiceLevel);

        assertNotNull(cartMenuItems);
        assertEquals(menuItem, cartMenuItems.getMenuItem());
        assertEquals(quantity, cartMenuItems.getQuantity());
        assertEquals(note, cartMenuItems.getNote());
        assertEquals(spiceLevel, cartMenuItems.getSpiceLevel());
    }

    @Test
    void testBuildCartMenuItem_Failing() {
        MenuItem menuItem = mock(MenuItem.class);
        when(menuItem.getId()).thenReturn(0L);

        int quantity = 0;
        String note = "Extra spicy";
        SpiceLevel spiceLevel = SpiceLevel.HIGH;

        CartMenuItems cartMenuItems = CartMenuItemsFactory.buildCartMenuItem(menuItem, quantity, note, spiceLevel);

        assertNull(cartMenuItems);
    }

}