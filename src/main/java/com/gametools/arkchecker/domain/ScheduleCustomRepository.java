package com.gametools.arkchecker.domain;

import java.util.List;

public interface ScheduleCustomRepository {
    List<Schedule> findAllByCharacterName(String characterName);
}
