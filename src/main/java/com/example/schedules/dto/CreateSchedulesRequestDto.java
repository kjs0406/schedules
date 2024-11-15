package com.example.schedules.dto;

import lombok.Getter;

@Getter
public class CreateSchedulesRequestDto {

    private final String title;

    private final String contents;

    private final String username;

    public CreateSchedulesRequestDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }

}
