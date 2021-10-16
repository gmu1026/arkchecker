package com.gametools.arkchecker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Character {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column
    private Classes classes;

    @Column
    private Integer battleLevel;

    @Column
    private Integer itemLevel;

    @Builder
    public Character(String name, Classes classes,
        Integer battleLevel, Integer itemLevel) {
        this.name = name;
        this.classes = classes;
        this.battleLevel = battleLevel;
        this.itemLevel = itemLevel;
    }
}
