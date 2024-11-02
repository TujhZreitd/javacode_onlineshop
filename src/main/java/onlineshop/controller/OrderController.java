package onlineshop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import onlineshop.model.Order;
import onlineshop.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final ObjectMapper objectMapper;

    @PostMapping
    public String createNewOrder(@RequestBody String json) throws Exception {
        Order order = objectMapper.readValue(json, Order.class);
        return objectMapper.writeValueAsString(orderService.save(order));
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable int id) throws Exception {
        return objectMapper.writeValueAsString(orderService.findById(id));
    }
}
