package onlineshop.service;

import lombok.AllArgsConstructor;
import onlineshop.model.Order;
import onlineshop.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleOrderService implements OrderService {
    private final OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order findById(int id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.orElseThrow(() -> new RuntimeException("Order not found"));
    }
}
