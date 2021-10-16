package com.gametools.arkchecker.service;

import com.gametools.arkchecker.domain.Schedule;
import com.gametools.arkchecker.domain.dto.ScheduleClearRequestDto;
import com.gametools.arkchecker.domain.dto.ScheduleRegisterRequestDto;
import java.util.List;

public interface ScheduleService {
    void register(ScheduleRegisterRequestDto requestDto);
    List<Schedule> getCharacterSchedules(String characterName);
    List<Schedule> getAllSchedule();
    Boolean scheduleClear(ScheduleClearRequestDto requestDto);
}
