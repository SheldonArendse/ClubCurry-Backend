package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Address> read(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.read(id));
    }


    @PutMapping("/update")
    public ResponseEntity<Address> update(@RequestBody Address obj) {
        //  updates with addresses
        Address address = AddressFactory.buildAddress(obj.getId(),obj.getStreetName(), obj.getStreetNo(), obj.getSuburb().getSuburbName(), obj.getSuburb().getPostalCode());
        if(address == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(addressService.save(address));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.delete(id));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Address>>getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAll());
    }

    @PutMapping("/assignCustomer/{addressId}/{customerEmail}")
    public ResponseEntity<Address> assignCustomer(@PathVariable Long addressId, @PathVariable String customerEmail){
        Address a1 = addressService.read(addressId);


    }
}
