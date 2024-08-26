package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.Driver;
import za.ac.cput.repository.DriverRepo;
import za.ac.cput.service.interfaces.IDriverService;
import za.ac.cput.service.interfaces.IService;

import java.util.List;

@Service
public class DriverService implements IDriverService{
    private DriverRepo driverRepo;

    @Autowired
    public DriverService(DriverRepo driverRepo) {
        this.driverRepo = driverRepo;
    }

    @Override
    public Driver save(Driver obj) {
        return driverRepo.save(obj);
    }

    @Override
    public Driver read(String s) {
        return driverRepo.findById(s).orElse(null);
    }

    @Override
    public Driver update(Driver obj) {
        if(driverRepo.existsById(obj.getId())){
            return driverRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(String s) {
        if(driverRepo.existsById(s)){
            driverRepo.deleteById(s);
            return true;
        }
        return false;
    }

    @Override
    public List<Driver> getAll() {
        return driverRepo.findAll();
    }
}
