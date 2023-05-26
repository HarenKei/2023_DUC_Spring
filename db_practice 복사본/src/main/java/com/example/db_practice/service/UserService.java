package com.example.db_practice.service;

import com.example.db_practice.dto.UserDto;
import com.example.db_practice.dto.UserResponseDto;

public interface UserService {
    UserResponseDto getUser(Long id);
    UserResponseDto saveUser(UserDto userDto);
    UserResponseDto changeUserName(Long id, String name) throws Exception;
    void deleteUser(Long id) throws Exception;
}
