package ru.nsu.gorin.ooaid.new_diner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.gorin.ooaid.new_diner.entities.OrderEntity;
import ru.nsu.gorin.ooaid.new_diner.model.OrderQueueObject;
import ru.nsu.gorin.ooaid.new_diner.service.CompleteOrderService;
import ru.nsu.gorin.ooaid.new_diner.service.DeclineOrderService;
import ru.nsu.gorin.ooaid.new_diner.service.OrderQueueService;

import java.util.Map;

@RestController
@RequestMapping("/diner/cook")
public class CookActionsController {
    private final CompleteOrderService completeOrderService;
    private final DeclineOrderService declineOrderService;
    private final OrderQueueService orderQueueService;

    @Autowired
    public CookActionsController(CompleteOrderService completeOrderService, DeclineOrderService declineOrderService, OrderQueueService orderQueueService) {
        this.completeOrderService = completeOrderService;
        this.declineOrderService = declineOrderService;
        this.orderQueueService = orderQueueService;
    }

    @GetMapping("/orders")
    public ResponseEntity<String> getAllOrders() {
        return ResponseEntity.ok().body(orderQueueService.getOrderQueue().toString());
    }

    @PostMapping("/orders/{orderId}/complete")
    public ResponseEntity<?> completeOrder(@PathVariable long orderId) {
        completeOrderService.completeOrder(orderId);
        return ResponseEntity.ok().body("Order " + orderId + " completed successfully");
    }

    @PostMapping("/orders/{orderId}/decline")
    public ResponseEntity<?> declineOrder(@PathVariable long orderId) {
        declineOrderService.declineOrder(orderId);
        return ResponseEntity.ok().body("Order " + orderId + " declined successfully");
    }
}
