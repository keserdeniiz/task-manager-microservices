package com.taskmanager.user_service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponseDto {
    private String token;
    private String email;
    private String role;
}
