package com.example.schedules.dto;

import lombok.Getter;

@Getter
public class SchedulesRequestDto {

    private String title;

    private String contents;

    public SchedulesRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}