package com.taskmanager.user_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.taskmanager.user_service.model.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Response object returned after user operations")
public class UserResponseDto {

    @JsonProperty("id")
    @Schema(description = "Unique identifier for the user", example = "101")
    private Long id;

    @JsonProperty("full_name")
    @Schema(description = "Registered full name of the user", example = "Harvey Specter")
    private String fullName;

    @JsonProperty("email")
    @Schema(description = "Email address associated with the user", example = "harvey.specter@firma.com")
    private String email;

    @JsonProperty("created_at")
    @Schema(description = "Timestamp when the user account was created", example = "2025-11-27T14:09:00")
    private LocalDateTime createdAt;

    public static UserResponseDto toDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .createdAt(user.getCreatedAt())
                .build();
    }
}

