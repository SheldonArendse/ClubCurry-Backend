package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.enums.Section;
import za.ac.cput.domain.enums.Status;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BookingFactoryTest {
    @Test
    void testBuildBookingWithId_Passing() {
        Long id = 1L;
        LocalTime time = LocalTime.now().plusHours(1);
        LocalDate date = LocalDate.now();
        int tableNo = 5;
        Section sectionNo = Section.A;
        Status status = Status.APPROVED;
        GeneralStaff bookedBy = mock(GeneralStaff.class);

        Booking booking = BookingFactory.buildBooking(id, time, date, tableNo, sectionNo, status, bookedBy);

        assertNotNull(booking);
        assertEquals(id, booking.getBookingId());
        assertEquals(time.toString(), booking.getTime());
        assertEquals(date.toString(), booking.getDate());
        assertEquals(tableNo, booking.getTableNo());
        assertEquals(sectionNo, booking.getSectionNo());
        assertEquals(status, booking.getStatus());
        assertEquals(bookedBy, booking.getBookedBy());
    }

    @Test
    void testBuildBookingWithId_Failing() {
        Long id = 0L;
        LocalTime time = LocalTime.now().minusHours(1);
        LocalDate date = LocalDate.now().minusDays(1);
        int tableNo = 0;
        Section sectionNo = null;
        Status status = null;
        GeneralStaff bookedBy = null;

        Booking booking = BookingFactory.buildBooking(id, time, date, tableNo, sectionNo, status, bookedBy);

        assertNull(booking);
    }

}