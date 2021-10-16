package com.gametools.arkchecker.domain;

import static com.gametools.arkchecker.domain.QContent.content;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class ContentCustomRepositoryImpl implements ContentCustomRepository {
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Content> findAllByRequiredLevel(Integer itemLevel) {
        return queryFactory
            .selectFrom(content)
            .where(content.requireItemLevel.loe(itemLevel))
            .fetch();
    }
}
