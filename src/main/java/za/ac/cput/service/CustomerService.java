package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepo;
import za.ac.cput.service.interfaces.ICustomerService;
import za.ac.cput.service.interfaces.IService;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer save(Customer obj) {
        return customerRepo.save(obj);
    }

    @Override
    public Customer read(String s) {
        return customerRepo.findById(s).orElse(null);
    }

    @Override
    public Customer update(Customer obj) {
        if(customerRepo.existsById(obj.getEmail())){
            return customerRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(String s) {
        if(customerRepo.existsById(s)){
            customerRepo.deleteById(s);
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepo.findAll();
    }
}
