package com.gametools.arkchecker.domain.dto;

import com.gametools.arkchecker.domain.Content;
import com.gametools.arkchecker.domain.ContentsType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ContentRegisterRequestDto {
    private String name;
    private Integer requireItemLevel;
    private Integer rewardGold;
    private String contentType;

    public Content toEntity() {
        return Content.builder()
            .name(this.name)
            .requireItemLevel(this.requireItemLevel)
            .rewardGold(this.rewardGold)
            .contentsType(ContentsType.valueOf(this.contentType))
            .build();
    }
}
