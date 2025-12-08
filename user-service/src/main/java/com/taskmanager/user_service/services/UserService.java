package com.taskmanager.user_service.services;

import com.taskmanager.user_service.dto.AuthResponseDto;
import com.taskmanager.user_service.dto.UserLoginDto;
import com.taskmanager.user_service.dto.UserRequestDto;
import com.taskmanager.user_service.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    UserResponseDto register(UserRequestDto request);
    AuthResponseDto login(UserLoginDto request);
    UserResponseDto getUserById(Long id);
    void deleteUser(Long id);
    List<UserResponseDto> getAllUsers();
}
