package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Guest;
import za.ac.cput.factory.GuestFactory;
import za.ac.cput.service.GuestService;

import java.util.List;

@RestController
@RequestMapping("/guest")
public class GuestController {

    private GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService){this.guestService=guestService;
    }

    @PostMapping("/create")
    public Guest create(@RequestBody Guest obj){
        Guest guest = GuestFactory.buildGuest(obj.getEmail(),obj.getFirstName(),obj.getLastName(),obj.getMobileNumber(),obj.getGuestAddress(),obj.getPaymentMethod());
        return guestService.create(obj);
    }

    @GetMapping("/read/{id}")
    public Guest read(@PathVariable String id){
        return guestService.read(id);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        Guest guest = GuestFactory.buildGuest(id);
        guestService.delete(guest);
    }

    @PostMapping("/getAll")
    public List<Guest> getAll(){
        return guestService.getAll();
    }
}
