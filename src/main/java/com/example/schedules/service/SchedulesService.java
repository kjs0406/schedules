package com.example.schedules.service;

import com.example.schedules.dto.SchedulesResponseDto;
import com.example.schedules.entity.Schedules;
import com.example.schedules.entity.User;
import com.example.schedules.repository.SchedulesRepository;
import com.example.schedules.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchedulesService {

    private final UserRepository userRepository;
    private final SchedulesRepository schedulesRepository;

    public SchedulesResponseDto save(String title, String contents, String username) {

        User findUser = userRepository.findByUsernameOrElseThrow(username);

        Schedules schedules = new Schedules(title, contents);
        schedules.setUser(findUser);

        Schedules savedSchedules = schedulesRepository.save(schedules);

        return new SchedulesResponseDto(savedSchedules.getId(), savedSchedules.getTitle(), savedSchedules.getContents());
    }

    public List<SchedulesResponseDto> findAll() {

        return schedulesRepository.findAll()
                .stream()
                .map(SchedulesResponseDto::toDto)
                .toList();
    }

    public SchedulesResponseDto findById(Long id) {
        Schedules findSchedules = schedulesRepository.findByIdOrElseThrow(id);

        return new SchedulesResponseDto(findSchedules.getId(),findSchedules.getTitle(), findSchedules.getContents());
    }

    @Transactional
    public void updateSchedules(Long id, String title, String contents) {
       Schedules findSchedules = schedulesRepository.findByIdOrElseThrow(id);
        if (title == null || contents == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "제목과 내용이 빈값이면 안됩니다.");
        }

        findSchedules.updateSchedules(title,contents);

    }

    public void delete(Long id) {

        Schedules findSchedules = schedulesRepository.findByIdOrElseThrow(id);

        schedulesRepository.delete(findSchedules);
    }
}
