package com.example.schedules.controller;

import com.example.schedules.dto.CreateSchedulesRequestDto;
import com.example.schedules.dto.SchedulesRequestDto;
import com.example.schedules.dto.SchedulesResponseDto;
import com.example.schedules.service.SchedulesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<SchedulesResponseDto>> findAll() {
        List<SchedulesResponseDto> schedulesResponseDtoList = schedulesService.findAll();

        return new ResponseEntity<>(schedulesResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchedulesResponseDto> findById(@PathVariable Long id) {

        SchedulesResponseDto schedulesResponseDto = schedulesService.findById(id);

        return new ResponseEntity<>(schedulesResponseDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSchedules(
            @PathVariable Long id,
            @RequestBody SchedulesRequestDto requestDto
    ) {

        schedulesService.updateSchedules(id, requestDto.getTitle(), requestDto.getContents());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        schedulesService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
