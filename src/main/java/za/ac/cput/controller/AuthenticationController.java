package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.Employee;
import za.ac.cput.service.AdminService;
import za.ac.cput.service.CustomerService;
import za.ac.cput.service.DriverService;
import za.ac.cput.service.GenStaffService;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    private final AdminService adminService;
    private final CustomerService customerService;
    private final GenStaffService generalStaffService;
    private final DriverService driverService;

    @Autowired
    public AuthenticationController(AdminService adminService, CustomerService customerService, GenStaffService generalStaffService, DriverService driverService){
        this.adminService = adminService;
        this.customerService = customerService;
        this.generalStaffService = generalStaffService;
        this.driverService = driverService;
    }

    @GetMapping("/customer/{email}/{password}")
    public ResponseEntity<Customer> loginCustomer(@PathVariable String email, @PathVariable String password){
        if(customerService.read(email).getPassword().equals(password)){
            return ResponseEntity.ok().body(customerService.read(email));
        };
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/employee/{username}/{password}")
    public ResponseEntity<Employee> loginEmployee(@PathVariable String username, @PathVariable String password){
        if(adminService.read(username).getPassword().equals(password)){
            return ResponseEntity.ok().body(adminService.read(username));
        }
        if(generalStaffService.read(username).getPassword().equals(password)){
            return ResponseEntity.ok().body(generalStaffService.read(username));
        }
        if(driverService.read(username).getPassword().equals(password)){
            return ResponseEntity.ok().body(driverService.read(username));
        }
        return ResponseEntity.notFound().build();
    }


}
