/*
package com.example.appdevassignment.controllers;

import com.example.appdevassignment.dtos.UserCreateDTO;
import com.example.appdevassignment.entities.User;
import com.example.appdevassignment.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserCreateDTO dto) {
        return ResponseEntity.ok(userService.createUser(dto));
    }

    @PatchMapping("/{id}/password")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<User> updatePassword(@PathVariable Long id, @RequestBody String password) {
        return ResponseEntity.ok(userService.updatePassword(id, password));
    }

    @PatchMapping("/{id}/toggle-lock")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<User> toggleLocked(@PathVariable Long id) {
        return ResponseEntity.ok(userService.toggleLocked(id));
    }

    @DeleteMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
*/
