package com.gametools.arkchecker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Content {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private Integer requireItemLevel;

    private Integer rewardGold;

    @Enumerated(EnumType.STRING)
    private ContentsType contentsType;

    @Builder
    public Content(String name, Integer requireItemLevel,
        Integer rewardGold, ContentsType contentsType) {
        this.name = name;
        this.requireItemLevel = requireItemLevel;
        this.rewardGold = rewardGold;
        this.contentsType = contentsType;
    }
}
