package com.taskmanager.user_service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.taskmanager.user_service.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("email")
    private String email;

    @Enumerated(EnumType.STRING)
    @JsonProperty("role")
    private Role role;

    @JsonProperty("password")
    private String password;

    @JsonProperty("created_time")
    private LocalDateTime createdAt;
}
