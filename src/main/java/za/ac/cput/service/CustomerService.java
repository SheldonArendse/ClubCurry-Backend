package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer obj) {
        return customerRepository.save(obj);
    }

    @Override
    public Customer read(String s) {
        return customerRepository.findById(s).orElse(null);
    }

    @Override
    public void delete(Customer obj) {
        customerRepository.delete(obj);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

}
