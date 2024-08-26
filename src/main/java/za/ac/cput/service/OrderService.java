package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Orders;
import za.ac.cput.repository.OrderRepo;
import za.ac.cput.service.interfaces.IOrderService;
import za.ac.cput.service.interfaces.IService;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    private OrderRepo orderRepo;

    @Autowired
    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public Orders save(Orders obj) {
        return orderRepo.save(obj);
    }

    @Override
    public Orders read(Long aLong) {
        return orderRepo.findById(aLong).orElse(null);
    }

    @Override
    public Orders update(Orders obj) {
        if(orderRepo.existsById(obj.getId())){
            return orderRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        if(orderRepo.existsById(aLong)){
            orderRepo.deleteById(aLong);
            return true;
        }
        return false;
    }

    @Override
    public List<Orders> getAll() {
        return orderRepo.findAll();
    }
}
