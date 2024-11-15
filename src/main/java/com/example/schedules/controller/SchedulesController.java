package com.example.schedules.controller;

import com.example.schedules.dto.CreateSchedulesRequestDto;
import com.example.schedules.dto.SchedulesResponseDto;
import com.example.schedules.service.SchedulesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
@RequiredArgsConstructor
public class SchedulesController {

    private final SchedulesService schedulesService;

    @PostMapping
    public ResponseEntity<SchedulesResponseDto> save(@RequestBody CreateSchedulesRequestDto requestDto) {

        SchedulesResponseDto schedulesResponseDto =
                schedulesService.save(
                        requestDto.getTitle(),
                        requestDto.getContents(),
                        requestDto.getUsername()
                );

        return new ResponseEntity<>(schedulesResponseDto, HttpStatus.CREATED);
    }
}
