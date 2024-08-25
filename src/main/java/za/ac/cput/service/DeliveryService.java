package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Delivery;
import za.ac.cput.repository.DeliveryRepo;
import za.ac.cput.service.interfaces.IDeliveryService;

import java.util.List;

@Service
public class DeliveryService implements IDeliveryService {

    private final DeliveryRepo deliveryRepo;

    @Autowired
    public DeliveryService(DeliveryRepo deliveryRepo) {
        this.deliveryRepo = deliveryRepo;
    }

    @Override
    public Delivery save(Delivery obj) {
        return deliveryRepo.save(obj);
    }

    @Override
    public Delivery read(Long id) {
        return deliveryRepo.findById(id).orElse(null);
    }

    @Override
    public Delivery update(Delivery obj) {
        if (deliveryRepo.existsById(obj.getId())) {
            return deliveryRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        if (deliveryRepo.existsById(id)) {
            deliveryRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Delivery> getAll() {
        return deliveryRepo.findAll();
    }
}
