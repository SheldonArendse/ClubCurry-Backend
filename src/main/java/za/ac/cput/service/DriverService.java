package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Driver;
import za.ac.cput.repository.DriverRepository;

import java.util.List;
@Service
public class DriverService implements IDriverService{

    private final DriverRepository driverRepository;
    @Autowired

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver create(Driver obj) {
        return driverRepository.save(obj);
    }

    @Override
    public Driver read(String s) {
        return driverRepository.findById(s).orElse(null);
    }

    @Override
    public void delete(Driver obj) {
        driverRepository.delete(obj);

    }

    @Override
    public List<Driver> getAll() {
        return driverRepository.findAll();
    }
}
