package com.taskmanager.taskservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.taskmanager.taskservice.enums.TaskStatus;
import com.taskmanager.taskservice.model.Task;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data Transfer Object for Task Response")
public class TaskResponseDto {
    @JsonProperty("id")
    @Schema(description = "Unique identifier for the task", example = "42")
    private Long id;

    @JsonProperty("title")
    @Schema(description = "Task title", example = "Implement user onboarding flow")
    private String title;

    @JsonProperty("description")
    @Schema(description = "Detailed explanation of the task", example = "Design the onboarding screens, implement API integrations, and add analytics events.")
    private String description;

    @JsonProperty("status")
    @Schema(description = "Current task status", example = "CREATED")
    private TaskStatus status;

    @JsonProperty("created_time")
    @Schema(description = "Timestamp when task was created", example = "2025-11-26T20:00:00")
    private LocalDateTime createdAt;

    @JsonProperty("update_time")
    @Schema(description = "Timestamp when task was last updated", example = "2025-11-27T14:32:10")
    private LocalDateTime updateAt;

    public static TaskResponseDto toDto(Task task){
        return TaskResponseDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .createdAt(task.getCreatedAt())
                .updateAt(task.getUpdateAt())
                .build();
    }
}
