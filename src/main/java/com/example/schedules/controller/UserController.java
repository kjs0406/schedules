package com.example.schedules.controller;

import com.example.schedules.dto.UserRequestDto;
import com.example.schedules.dto.UserResponseDto;
import com.example.schedules.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> signUp(@RequestBody UserRequestDto requestDto) {

        UserResponseDto userResponseDto =
                userService.addUser(
                        requestDto.getUsername(),
                        requestDto.getPassword(),
                        requestDto.getEmail()
                );

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        UserResponseDto userResponseDto = userService.findById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
