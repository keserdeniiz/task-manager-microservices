package com.taskmanager.user_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.taskmanager.user_service.model.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Payload object used when registering a new user")
public class UserRequestDto {

    @JsonProperty("full_name")
    @Schema(description = "Full name of the user who is registering", example = "Harvey Specter")
    private String fullName;

    @JsonProperty("email")
    @Schema(description = "Email address used as the login identifier", example = "harvey@example.com.tr")
    private String email;

    @JsonProperty("password")
    @Schema(description = "Raw password that will be securely hashed before being stored", example = "strong-password-123")
    private String password;

    public User toEntity(UserRequestDto userRequestDto){
        return User.builder()
                .fullName(userRequestDto.getFullName())
                .email(userRequestDto.getEmail())
                .password(userRequestDto.getPassword())
                .build();
    }
}
