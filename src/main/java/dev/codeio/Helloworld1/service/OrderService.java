package dev.codeio.Helloworld1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.codeio.Helloworld1.DTO.OrderData;
import dev.codeio.Helloworld1.Repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Create or Save Order
    public OrderData createOrder(OrderData order) {
        return orderRepository.save(order);
    }

    // Get all orders
    public List<OrderData> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get order by ID
    public Optional<OrderData> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    // Update order by ID
    public OrderData updateOrder(Long id, OrderData updatedOrder) {
        return orderRepository.findById(id).map(existingOrder -> {
            existingOrder.setCustomerName(updatedOrder.getCustomerName());
            existingOrder.setProductName(updatedOrder.getProductName());
            existingOrder.setQuantity(updatedOrder.getQuantity());
            existingOrder.setTotalAmount(updatedOrder.getTotalAmount());
            existingOrder.setOrderStatus(updatedOrder.getOrderStatus());
            return orderRepository.save(existingOrder);
        }).orElse(null);
    }

    // Delete order by ID
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
