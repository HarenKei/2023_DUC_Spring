package com.example.db_practice.controller;

import com.example.db_practice.dto.ChangeUserDto;
import com.example.db_practice.dto.UserDto;
import com.example.db_practice.dto.UserResponseDto;
import com.example.db_practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class userController {
    private final UserService userService;

    @Autowired
    public userController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<UserResponseDto> getUser(Long id) {
        UserResponseDto userResponseDto = userService.getUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @PostMapping()
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserDto userDto) {
        UserResponseDto userResponseDto = userService.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @PutMapping()
    public ResponseEntity<UserResponseDto> changeUserName(@RequestBody ChangeUserDto changeUserDto) throws Exception {
        UserResponseDto userResponseDto = userService.changeUserName(changeUserDto.getId(), changeUserDto.getName());
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteUser(Long id) throws Exception {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

}
