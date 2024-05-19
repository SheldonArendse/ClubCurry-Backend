package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Order;
import za.ac.cput.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService implements IOrderService{
    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order read(String orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }
    @Override
    public void delete(String orderId) {
        orderRepository.deleteById(orderId);

    }
    @Override
    public List<Order> getall() {
        return orderRepository.findAll();
    }
}
