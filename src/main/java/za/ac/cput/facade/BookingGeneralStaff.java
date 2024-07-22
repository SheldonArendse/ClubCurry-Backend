package za.ac.cput.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.GeneralStaff;
import za.ac.cput.service.BookingService;
import za.ac.cput.service.GenStaffService;

@Component
public class BookingGeneralStaff {
    private BookingService bookingService;
    private GenStaffService genStaffService;

    @Autowired
    public BookingGeneralStaff(BookingService bookingService, GenStaffService genStaffService) {
        this.bookingService = bookingService;
        this.genStaffService = genStaffService;
    }

    public Booking canSave(Booking obj){
        if(genStaffService.read(obj.getBookedBy().getId()) != null){
            return obj;
        }
        return null;
    }
}
