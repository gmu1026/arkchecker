package com.gametools.arkchecker.domain.dto;

import com.gametools.arkchecker.domain.Character;
import com.gametools.arkchecker.domain.Content;
import com.gametools.arkchecker.domain.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ScheduleRegisterRequestDto {
    private String characterName;
    private String contentName;

    public Schedule toEntity(Character character, Content content) {
        return Schedule.builder()
            .character(character)
            .content(content)
            .build();
    }
}
