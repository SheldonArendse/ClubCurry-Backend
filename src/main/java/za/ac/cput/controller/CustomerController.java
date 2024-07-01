package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public ResponseEntity<Customer> save(@RequestBody Customer obj) {
        // builds a customer with no addresses
        Customer buildObj = CustomerFactory.buildCustomer(obj.getEmail(), obj.getName(), obj.getSurname(), obj.getMobileNo(), obj.getPassword());
        if(buildObj == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(customerService.save(buildObj));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> read(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.read(id));
    }


    @PutMapping("/update")
    public ResponseEntity<Customer> update(@RequestBody Customer obj) {
        //  updates with addresses
        Customer buildObj = CustomerFactory.buildCustomer(obj.getEmail(), obj.getName(), obj.getSurname(), obj.getMobileNo(), obj.getPassword(), obj.getAddresses());
        if(buildObj == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(customerService.save(buildObj));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.delete(id));
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>>getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAll());
    }

    @GetMapping("/login")
    public ResponseEntity<Customer> login(@RequestBody Customer obj){
        Customer login = CustomerFactory.buildCustomer(obj.getEmail(), obj.getPassword());

        if(login == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }

        return ResponseEntity.status(HttpStatus.OK).body(customerService.findByEmailAndPassword(login.getEmail(), login.getPassword()));
    }
}
