package com.gametools.arkchecker.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Schedule {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Content content;

    @OneToOne
    private Character character;

    private Boolean clear;

    private LocalDateTime clearedDate;

    @Builder
    public Schedule(Content content, Character character) {
        this.content = content;
        this.character = character;
    }

    public void clearSchedule() {
        this.clear = true;
        this.clearedDate = LocalDateTime.now();
    }
}
