package com.taskmanager.user_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Payload object used when a user attempts to log in")
public class UserLoginDto {

    @JsonProperty("email")
    @Schema(description = "Email address associated with the user's account", example = "harvey.specter@firma.com")
    private String email;

    @JsonProperty("password")
    @Schema(description = "Raw password submitted during login. Will be validated against the stored hash.", example = "strong-password-123")
    private String password;
}
