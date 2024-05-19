package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Guest;
import za.ac.cput.repository.GuestRepository;

import java.util.List;

@Service
public class GuestService implements IGuestService{

    private GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository){
        this.guestRepository = guestRepository;
    }


    @Override
    public Guest create(Guest obj) {
        return guestRepository.save(obj);
    }

    @Override
    public Guest read(String s) {
        return guestRepository.findById(s).orElseThrow(null);
    }

    @Override
    public void delete(Guest obj) {
guestRepository.delete(obj);
    }

    @Override
    public List<Guest> getAll() {
        return guestRepository.findAll();
    }
}
