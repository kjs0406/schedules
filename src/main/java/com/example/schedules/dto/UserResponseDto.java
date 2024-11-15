package com.example.schedules.dto;

import lombok.Getter;

@Getter
public class UserResponseDto {

    private final long id;

    private final String username;

    private final String password;

    private final String email;

    public UserResponseDto(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
