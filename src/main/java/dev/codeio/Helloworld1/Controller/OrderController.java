package dev.codeio.Helloworld1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dev.codeio.Helloworld1.DTO.OrderData;
import dev.codeio.Helloworld1.service.OrderService;

import java.util.List;
import java.util.function.Supplier;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // ✅ Create new order
    @PostMapping("/create")
    public ResponseEntity<OrderData> createOrder(@RequestBody OrderData order) {
        OrderData savedOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }

    // ✅ Get all orders
    @GetMapping("/all")
    public ResponseEntity<List<OrderData>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    // ✅ Get order by ID
    @SuppressWarnings("unchecked")
	@GetMapping("/get")
    public ResponseEntity<?> getOrderById(@RequestParam Long id) {
        return orderService.getOrderById(id)
                .map(order -> ResponseEntity.ok(order))
                .orElseThrow();
    }

    // ✅ Update order by ID (RequestParam + JSON Body)
    @PutMapping("/update")
    public ResponseEntity<?> updateOrder(@RequestParam Long id, @RequestBody OrderData updatedOrder) {
        OrderData order = orderService.updateOrder(id, updatedOrder);
        if (order != null) {
            return ResponseEntity.ok(order);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Order not found with ID: " + id);
    }

//     ✅ DELETE ORDER BY ID
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteOrder(@RequestParam Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.ok("Order deleted successfully with ID: " + id);
    }
    
    @GetMapping("/status")
    public ResponseEntity<String> getOrderStatus(@RequestParam Long id) {
    	boolean status=true;
		if (status != true) {
			return ResponseEntity.ok("Order status for ID " + id + ": " + status);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body("Order not found with ID: " + id);
	}
    
}
