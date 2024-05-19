package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Delivery;
import za.ac.cput.repository.DeliveryRepository;

import java.util.List;

@Service
public class DeliveryService implements IDeliveryService {

    private DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public Delivery create(Delivery obj) {
        return deliveryRepository.save(obj);
    }

    @Override
    public Delivery read(String s) {
        return deliveryRepository.findById(s).orElseThrow(null);
    }
    
    @Override
    public void delete(Delivery obj) {
        deliveryRepository.delete(obj);
    }

    @Override
    public List<Delivery> getAll() {
        return deliveryRepository.findAll();
    }
}
