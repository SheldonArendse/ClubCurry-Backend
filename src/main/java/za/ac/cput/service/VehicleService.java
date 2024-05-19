package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Vehicle;
import za.ac.cput.repository.VehicleRepository;

import java.util.List;

@Service
public class VehicleService implements IVehicleService{

    private final VehicleRepository vehicleRepository;
    @Autowired

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle create(Vehicle obj) {

        return vehicleRepository.save(obj);
    }

    @Override
    public Vehicle read(String s) {
        return vehicleRepository.findById(s).orElse(null);
    }

    @Override
    public void delete(Vehicle obj) {
        vehicleRepository.delete(obj);

    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }
}
