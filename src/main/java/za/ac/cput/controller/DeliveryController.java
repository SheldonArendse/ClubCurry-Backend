package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.Driver;
import za.ac.cput.factory.DeliveryFactory;
import za.ac.cput.factory.DriverFactory;
import za.ac.cput.service.DeliveryService;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @PostMapping("/create")
    public Delivery create(@RequestBody Delivery obj) {
        Delivery delivery1 = DeliveryFactory.buildDelivery(obj.getDeliveryId(), obj.getDeliveryTime(), obj.getStatus(), obj.getDriverId(), obj.getDeliveredAt(), obj.getDeliveryNote());
        return deliveryService.create(delivery1);
    }

    @GetMapping("/read/{id}")
    public Delivery read(@PathVariable String id) {
        return deliveryService.read(id);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        Delivery delivery1 = DeliveryFactory.buildDelivery(id);
        deliveryService.delete(delivery1);
    }

    @GetMapping("/getAll")
    public List<Delivery> getAll() {
        return deliveryService.getAll();
    }
}
