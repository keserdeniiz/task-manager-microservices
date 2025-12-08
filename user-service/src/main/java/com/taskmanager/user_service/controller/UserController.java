package com.taskmanager.user_service.controller;

import com.taskmanager.user_service.dto.AuthResponseDto;
import com.taskmanager.user_service.dto.UserLoginDto;
import com.taskmanager.user_service.dto.UserRequestDto;
import com.taskmanager.user_service.dto.UserResponseDto;
import com.taskmanager.user_service.services.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Tag(name = "User API", description = "Operations related to user management")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Operation(summary = "Create new user", description = "Registers a new user in the system")
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(userRequestDto));
    }

    @Operation(summary = "User login", description = "Authenticates user and returns JWT token")
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody UserLoginDto dto) {
        return ResponseEntity.ok(userService.login(dto));
    }

    @Operation(summary = "Get user by ID")
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @Operation(summary = "Get all users")
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Operation(summary = "Delete user by ID")
    @SecurityRequirement(name = "bearerAuth")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
