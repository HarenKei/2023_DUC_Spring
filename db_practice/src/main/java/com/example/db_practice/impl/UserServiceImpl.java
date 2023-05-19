package com.example.db_practice.impl;

import com.example.db_practice.dao.UserDAO;
import com.example.db_practice.dto.UserDto;
import com.example.db_practice.dto.UserResponseDto;
import com.example.db_practice.entity.User;
import com.example.db_practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserResponseDto getUser(Long id) {
        User user = userDAO.selector(id);
        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setName(user.getName());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPassword(user.getPassword());

        return userResponseDto;
    }

    @Override
    public UserResponseDto saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setCreatedAt(LocalDateTime.now());
        User saveUser = userDAO.insertUser(user);

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setName(saveUser.getName());
        userResponseDto.setEmail(saveUser.getEmail());
        userResponseDto.setPassword(saveUser.getPassword());

        return userResponseDto;
    }

    @Override
    public UserResponseDto changeUserName(Long id, String name) throws Exception {
        User changeUser = userDAO.updateUserName(id, name);

        UserResponseDto userResponseDto = new UserResponseDto();

        userResponseDto.setId(changeUser.getId());
        userResponseDto.setName(changeUser.getName());
        userResponseDto.setEmail(changeUser.getEmail());
        userResponseDto.setPassword(changeUser.getPassword());

        return userResponseDto;
    }

    @Override
    public void deleteUser(Long id) throws Exception {
        userDAO.deleteUser(id);
    }
}
