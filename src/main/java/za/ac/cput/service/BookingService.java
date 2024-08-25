package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Booking;
import za.ac.cput.repository.BookingRepo;
import za.ac.cput.service.interfaces.IBookingService;

import java.util.List;

@Service
public class BookingService implements IBookingService {
    private BookingRepo bookingRepo;

    @Autowired
    public BookingService(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    @Override
    public Booking save(Booking obj) {
        return bookingRepo.save(obj);
    }

    @Override
    public Booking read(Long aLong) {
        return bookingRepo.findById(aLong).orElse(null);
    }

    @Override
    public Booking update(Booking obj) {
        if(bookingRepo.existsById(obj.getBookingId())){
            return bookingRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        if(bookingRepo.existsById(aLong)){
            bookingRepo.deleteById(aLong);
            return true;
        }
        return false;
    }

    @Override
    public List<Booking> getAll() {
        return bookingRepo.findAll();
    }
}
