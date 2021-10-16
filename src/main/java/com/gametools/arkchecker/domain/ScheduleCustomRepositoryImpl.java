package com.gametools.arkchecker.domain;

import static com.gametools.arkchecker.domain.QSchedule.schedule;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ScheduleCustomRepositoryImpl implements ScheduleCustomRepository {
    private final JPAQueryFactory queryFactory;
    private final CharacterRepository characterRepository;

    @Override
    public List<Schedule> findAllByCharacterName(String characterName) {
        Character character = characterRepository.findByName(characterName)
            .orElseThrow(() -> new IllegalArgumentException("해당 캐릭터가 없습니다."));

        return queryFactory
            .selectFrom(schedule)
            .where(schedule.character.eq(character))
            .fetch();
    }
}
