package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.AddressRepo;
import za.ac.cput.service.interfaces.IAddressService;
import za.ac.cput.service.interfaces.IService;

import java.util.List;

@Service
public class AddressService implements IAddressService {

    private AddressRepo addressRepo;

    @Autowired
    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    @Override
    public Address save(Address obj) {
        return addressRepo.save(obj);
    }

    @Override
    public Address read(Long s) {
        return addressRepo.findById(s).orElse(null);
    }

    @Override
    public Address update(Address obj) {
        if(addressRepo.existsById(obj.getId())){
            return addressRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(Long s) {
        if(addressRepo.existsById(s)){
            addressRepo.deleteById(s);
            return true;
        }
        return false;
    }

    @Override
    public List<Address> getAll() {
        return addressRepo.findAll();
    }
}
