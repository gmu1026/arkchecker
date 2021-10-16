package com.gametools.arkchecker.service;

import com.gametools.arkchecker.domain.Character;
import com.gametools.arkchecker.domain.CharacterRepository;
import com.gametools.arkchecker.domain.Content;
import com.gametools.arkchecker.domain.ContentRepository;
import com.gametools.arkchecker.domain.Schedule;
import com.gametools.arkchecker.domain.ScheduleRepository;
import com.gametools.arkchecker.domain.dto.ScheduleClearRequestDto;
import com.gametools.arkchecker.domain.dto.ScheduleRegisterRequestDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final CharacterRepository characterRepository;
    private final ContentRepository contentRepository;

    @Transactional
    @Override
    public void register(ScheduleRegisterRequestDto requestDto) {
        Character character = characterRepository.findByName(
            requestDto.getCharacterName()).orElseThrow(
                () -> new IllegalArgumentException("해당 캐릭터가 없습니다."));

        Content content = contentRepository.findByName(
            requestDto.getContentName()).orElseThrow(
            () -> new IllegalArgumentException("해당 컨텐츠가 없습니다."));

        Schedule schedule = requestDto.toEntity(character, content);

        scheduleRepository.save(schedule);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Schedule> getCharacterSchedules(String characterName) {
        return scheduleRepository.findAllByCharacterName(characterName);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Schedule> getAllSchedule() {
        return scheduleRepository.findAll();
    }

    @Transactional
    @Override
    public Boolean scheduleClear(ScheduleClearRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(requestDto.getScheduleId())
            .orElseThrow(() -> new IllegalArgumentException("해당 스케줄이 없습니다."));

        schedule.clearSchedule();

        return true;
    }
}
