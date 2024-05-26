package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public Customer create(@RequestBody Customer obj){
        Customer customer = CustomerFactory.buildCustomer(
                obj.getEmail(),
                obj.getFirstName(),
                obj.getLastName(),
                obj.getMobileNumber(),
                obj.getPassword(),
                obj.getCustAddress(),
                obj.getPaymentMethod());
        return customerService.create(obj);
    }

    @GetMapping("/read/{id}")
    public Customer read(@PathVariable String id){
        return customerService.read(id);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        Customer customer =CustomerFactory.buildCustomer(id);
        customerService.delete(customer);
    }

  @PostMapping("/getAll")
    public List<Customer> getAll(){
        return customerService.getAll();
    }
}
