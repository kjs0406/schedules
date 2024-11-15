package com.example.schedules.dto;

import com.example.schedules.entity.Schedules;
import lombok.Getter;

@Getter
public class SchedulesResponseDto {

    private final Long id;

    private final String title;

    private final String contents;

    public SchedulesResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }

    public static SchedulesResponseDto toDto(Schedules schedules) {
        return new SchedulesResponseDto(schedules.getId(), schedules.getTitle(), schedules.getContents());
    }
}
