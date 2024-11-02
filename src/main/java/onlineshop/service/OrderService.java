package onlineshop.service;

import onlineshop.model.Order;

public interface OrderService {
    Order save(Order order);
    Order findById(int id);
}
