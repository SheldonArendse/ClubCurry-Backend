package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.facade.CustomerAddress;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*") // Allow all origins and headers
public class AddressController {

    private AddressService addressService;

    private CustomerAddress customerAddress;

    @Autowired
    public AddressController(AddressService addressService, CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
        this.addressService = addressService;
    }

    @PostMapping("/save")
    public ResponseEntity<Address> save(@RequestBody Address obj) {
        // builds a customer with no addresses
        Address buildObj = AddressFactory.buildAddress(obj.getStreetName(), obj.getStreetNo(), obj.getSuburb().getSuburbName(), obj.getSuburb().getPostalCode(), obj.getCustomerId());
        if(buildObj == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }

        Address request = customerAddress.saveAddress(buildObj);

        if(request == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(request);
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
        return ResponseEntity.status(HttpStatus.OK).body(addressService.update(address));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.delete(id));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Address>>getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAll());
    }
}
