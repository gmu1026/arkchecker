package com.gametools.arkchecker.domain.dto;

import com.gametools.arkchecker.domain.Character;
import com.gametools.arkchecker.domain.Classes;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CharacterRegisterDto {
    @NotBlank(message = "이름을 반드시 입력해주세요")
    private String name;
    private String classes;
    private Integer battleLevel;
    private Integer itemLevel;

    public Character toEntity() {
        return Character.builder()
            .name(this.name)
            .classes(Classes.valueOf(this.classes))
            .battleLevel(this.battleLevel)
            .itemLevel(this.itemLevel)
            .build();
    }
}
