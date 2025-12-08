package com.taskmanager.taskservice.services;

import com.taskmanager.taskservice.dto.TaskRequestDto;
import com.taskmanager.taskservice.dto.TaskResponseDto;
import com.taskmanager.taskservice.enums.TaskStatus;
import com.taskmanager.taskservice.exception.TaskException;
import com.taskmanager.taskservice.model.Task;
import com.taskmanager.taskservice.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskResponseDto> getAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(TaskResponseDto::toDto)
                .toList();
    }

    @Override
    public TaskResponseDto getById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskException(id));
        return TaskResponseDto.toDto(task);
    }

    @Override
    public TaskResponseDto createTask(TaskRequestDto taskRequestDto) {
        Task task = Task.builder()
                .title(taskRequestDto.getTitle())
                .description(taskRequestDto.getDescription())
                .status(taskRequestDto.getStatus() != null ? taskRequestDto.getStatus() : TaskStatus.CREATED)
                .build();

        Task saved = taskRepository.save(task);
        return TaskResponseDto.toDto(saved);
    }

    @Override
    public TaskResponseDto updateTask(Long id, TaskRequestDto taskRequestDto) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskException(id));

        if (taskRequestDto.getTitle() != null) {
            task.setTitle(taskRequestDto.getTitle());
        }
        if (taskRequestDto.getDescription() != null) {
            task.setDescription(taskRequestDto.getDescription());
        }
        if (taskRequestDto.getStatus() != null) {
            task.setStatus(taskRequestDto.getStatus());
        }

        Task updated = taskRepository.save(task);
        return TaskResponseDto.toDto(updated);
    }

    @Override
    public void clearTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskException(id);
        }
        taskRepository.deleteById(id);
    }
}
