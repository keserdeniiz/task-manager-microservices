package com.taskmanager.taskservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.taskmanager.taskservice.dto.TaskRequestDto;
import com.taskmanager.taskservice.enums.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @Enumerated(EnumType.STRING)
    @JsonProperty("status")
    private TaskStatus status;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("update_at")
    private LocalDateTime updateAt;

    @PrePersist
    public void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updateAt = now;
        if (this.status == null) {
            this.status = TaskStatus.CREATED;
        }
    }

    @PreUpdate
    public void onUpdate() {
        this.updateAt = LocalDateTime.now();
    }
}
