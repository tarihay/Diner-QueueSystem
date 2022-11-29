package ru.nsu.gorin.ooaid.new_diner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nsu.gorin.ooaid.new_diner.entities.ProductEntity;
import ru.nsu.gorin.ooaid.new_diner.entities.UserEntity;
import ru.nsu.gorin.ooaid.new_diner.model.ProductDTO;
import ru.nsu.gorin.ooaid.new_diner.service.MenuService;
import ru.nsu.gorin.ooaid.new_diner.service.UsersService;

@RestController
@RequestMapping("/diner/admin")
public class AdminController {
    private final MenuService menuService;
    private final UsersService usersService;


    @Autowired
    public AdminController(MenuService menuService, UsersService usersService) {
        this.menuService = menuService;
        this.usersService = usersService;
    }

    @PostMapping("/addRoleToUser/{userId}/{roleId}")
    public ResponseEntity<UserEntity> addRoleToUser(@PathVariable long userId, @PathVariable long roleId) {
        return ResponseEntity.ok().body(usersService.addRoleToUser(userId, roleId));
    }

    @PostMapping("/products/create")
    public ResponseEntity<ProductEntity> createProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok().body(menuService.addProductToMenu(productDTO));
    }

    @PostMapping("/products/delete/{productId}")
    public ResponseEntity<ProductEntity> deleteProduct(@PathVariable long productId) {
        return ResponseEntity.ok().body(menuService.deleteProductFromMenu(productId));
    }


}
