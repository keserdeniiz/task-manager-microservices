package com.taskmanager.taskservice.services;

import com.taskmanager.taskservice.dto.TaskRequestDto;
import com.taskmanager.taskservice.dto.TaskResponseDto;
import com.taskmanager.taskservice.model.Task;

import java.util.List;

public interface TaskService {
    List<TaskResponseDto> getAllTasks();
    TaskResponseDto getById(Long id);
    TaskResponseDto createTask(TaskRequestDto taskRequestDto);
    TaskResponseDto updateTask(Long id, TaskRequestDto taskRequestDto);
    void clearTask(Long id);
}
