package com.gametools.arkchecker.domain;

import com.gametools.arkchecker.util.EnumModel;

public enum Classes implements EnumModel {
    DESTROYER("디스트로이어"),
    WARLOAD("워로드"),
    BERSERKER("버서커"),
    HOLYKNIGHT("홀리나이트"),
    BATTLEMASTER("배틀마스터"),
    INFIGHTER("인파이터"),
    SOULMASTER("기공사"),
    LANCEMASTER("창술사"),
    STRIKER("스트라이커"),
    DEVILHUNTER("데빌헌터"),
    BLASTER("블래스터"),
    HAWKEYE("호크아이"),
    SCOUTER("스카우터"),
    GUNSLINGER("건슬링어"),
    BARD("바드"),
    SUMMONER("서머너"),
    ARCANA("아르카나"),
    SORCERESS("소서리스"),
    BLADE("블레이드"),
    DEMONIC("데모닉"),
    REAPER("리퍼");

    private final String value;

    Classes(String value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return name();
    }

    @Override
    public String getValue() {
        return value;
    }
}
