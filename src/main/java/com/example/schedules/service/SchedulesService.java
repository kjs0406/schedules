package com.example.schedules.service;


import com.example.schedules.dto.SchedulesResponseDto;
import com.example.schedules.entity.Schedules;
import com.example.schedules.entity.User;
import com.example.schedules.repository.SchedulesRepository;
import com.example.schedules.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchedulesService {

    private final UserRepository userRepository;
    private final SchedulesRepository schedulesRepository;

    public SchedulesResponseDto save(String title, String contents, String username) {

        User findMember = userRepository.findMemberByUsernameOrElseThrow(username);

        Schedules schedules = new Schedules(title, contents);
        schedules.setUser(findUser);

        Schedules savedSchedules = schedulesRepository.save(schedules);

        return new SchedulesResponseDto(savedSchedules.getId(), savedSchedules.getTitle(), savedSchedules.getContents());
    }

}
