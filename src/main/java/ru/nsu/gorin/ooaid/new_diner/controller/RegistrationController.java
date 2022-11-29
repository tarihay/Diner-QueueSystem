package ru.nsu.gorin.ooaid.new_diner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nsu.gorin.ooaid.new_diner.model.UserDTO;
import ru.nsu.gorin.ooaid.new_diner.entities.UserEntity;
import ru.nsu.gorin.ooaid.new_diner.service.RegistrationService;
import ru.nsu.gorin.ooaid.new_diner.service.RolesService;

@RestController
@RequestMapping("/diner/signup")
public class RegistrationController {
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserEntity> registerUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok().body(registrationService.registerUser(userDTO));
    }

    @PostMapping("/admin")
    public ResponseEntity<UserEntity> registerAdmin(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok().body(registrationService.registerAdmin(userDTO));
    }
}
