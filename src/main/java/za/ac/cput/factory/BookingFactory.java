package za.ac.cput.factory;

import za.ac.cput.domain.Booking;
import za.ac.cput.domain.GeneralStaff;
import za.ac.cput.domain.enums.Section;
import za.ac.cput.domain.enums.Status;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BookingFactory {
    public static Booking buildBooking(Long id,String time, String date, int tableNo, Section sectionNo, Status status, GeneralStaff bookedBy){
        if(id>0 &&tableNo>0 && sectionNo !=null && status !=null && bookedBy !=null){
                    return new Booking.Builder().setBookingId(id)
                            .setTime(String.valueOf(time))
                            .setDate(String.valueOf(date))
                            .setTableNo(tableNo)
                            .setSectionNo(sectionNo)
                            .setBookedBy(bookedBy)
                            .setStatus(status).build();


        }
        return null;
    }

    public static Booking buildBooking(String time, String date, int tableNo, Section sectionNo, Status status, GeneralStaff bookedBy){
        if(tableNo>0 && sectionNo !=null && status !=null && bookedBy !=null){
                    return new Booking.Builder()
                            .setTime(String.valueOf(time))
                            .setDate(String.valueOf(date))
                            .setTableNo(tableNo)
                            .setSectionNo(sectionNo)
                            .setBookedBy(bookedBy)
                            .setStatus(status).build();


        }
        return null;
    }
    public static Booking buildBooking(String time, String date, int tableNo, Section sectionNo, Status status){
        if(tableNo>0 && sectionNo !=null && status !=null ){
                    return new Booking.Builder()
                            .setTime(String.valueOf(time))
                            .setDate(String.valueOf(date))
                            .setTableNo(tableNo)
                            .setSectionNo(sectionNo)
                            .setStatus(status).build();


        }
        return null;
    }

}
