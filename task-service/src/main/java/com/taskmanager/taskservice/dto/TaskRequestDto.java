package com.taskmanager.taskservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.taskmanager.taskservice.enums.TaskStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Data Transfer Object for Task Request")
public class TaskRequestDto {
    @JsonProperty("title")
    @Schema(description = "Task title", example = "Implement user onboarding flow")
    private String title;

    @JsonProperty("description")
    @Schema(description = "Detailed explanation of the task", example = "Design the onboarding screens, implement API integrations, and add analytics events.")
    private String description;

    @JsonProperty("status")
    @Schema(description = "Current task status", example = "CREATED")
    private TaskStatus status;
}
