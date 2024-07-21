package za.ac.cput.factory;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.enums.Section;
import za.ac.cput.domain.enums.Status;

import java.sql.Date;
import java.time.LocalDateTime;

public class BookingFactory {

    public static Booking buildBooking(long id, Date time, int tableNo, Section sectionNo, Status status){
        if(id>0 && time!=null && tableNo>0 && sectionNo !=null && status !=null){
            return new Booking.Builder()
                    .setBookingId(id)
                    .setTime(time)
                    .setTableNo(tableNo)
                    .setSectionNo(sectionNo)
                    .setStatus(status).build();
        }
        return null;
    }
    public static Booking buildBooking(Date time, int tableNo, Section sectionNo, Status status){
        if(time!=null && tableNo>0 && sectionNo !=null && status !=null){
            return new Booking.Builder()
                    .setTime(time)
                    .setTableNo(tableNo)
                    .setSectionNo(sectionNo)
                    .setStatus(status).build();
        }
        return null;
    }

}
