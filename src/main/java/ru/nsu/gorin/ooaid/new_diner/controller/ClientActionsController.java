package ru.nsu.gorin.ooaid.new_diner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.gorin.ooaid.new_diner.entities.ProductEntity;
import ru.nsu.gorin.ooaid.new_diner.exceptions.NoSuchProductFoundException;
import ru.nsu.gorin.ooaid.new_diner.model.OrderDTO;
import ru.nsu.gorin.ooaid.new_diner.service.MenuService;
import ru.nsu.gorin.ooaid.new_diner.service.SaveOrderService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/diner/menu")
public class ClientActionsController {
    private final SaveOrderService saveOrderService;
    private final MenuService menuService;

    @Autowired
    public ClientActionsController(SaveOrderService saveOrderService, MenuService menuService) {
        this.saveOrderService = saveOrderService;
        this.menuService = menuService;
    }

    @GetMapping()
    public ResponseEntity<List<ProductEntity>> getMenu() {
        return ResponseEntity.ok().body(menuService.getMenu());
    }

    @PostMapping("/basket/makeOrder")
    public ResponseEntity<String> saveOrder(@RequestBody OrderDTO orderDTO) throws NoSuchProductFoundException {
        return ResponseEntity.ok().body("Your id in the queue: " + saveOrderService.saveOrder(orderDTO));
    }

    @ExceptionHandler({NoSuchProductFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleException(NoSuchProductFoundException exception) {
        String savingOrderExceptionMessage = "Order contains invalid id of the product. It is not exist";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(savingOrderExceptionMessage);
    }
}
