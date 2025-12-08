package com.taskmanager.taskservice.controller;

import com.taskmanager.taskservice.dto.TaskRequestDto;
import com.taskmanager.taskservice.dto.TaskResponseDto;
import com.taskmanager.taskservice.services.TaskService;
import com.taskmanager.taskservice.services.TaskServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@Tag(name = "Task Management Operations")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "Get all tasks", description = "Returns list of all tasks")
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @Operation(summary = "Get task by ID", description = "Returns a single task")
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getById(id));
    }

    @Operation(summary = "Create task", description = "Creates a new task")
    @SecurityRequirement(name = "bearerAuth")
    @PostMapping
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto request) {
        return new ResponseEntity<>(taskService.createTask(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Update task", description = "Updates an existing task")
    @SecurityRequirement(name = "bearerAuth")
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponseDto> updateTask(@PathVariable Long id, @RequestBody TaskRequestDto request) {
        return ResponseEntity.ok(taskService.updateTask(id, request));
    }

    @Operation(summary = "Delete task", description = "Deletes the task by id")
    @SecurityRequirement(name = "bearerAuth")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.clearTask(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Service Health", description = "Service Health")
    @SecurityRequirement(name = "bearerAuth")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Service Health."),
            @ApiResponse(responseCode= "500", description = "Server Error")
    })
    @GetMapping("/ping")
    public boolean ping(){
        return true;
    }
}
