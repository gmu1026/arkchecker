package com.gametools.arkchecker.service;

import com.gametools.arkchecker.domain.Character;
import com.gametools.arkchecker.domain.dto.CharacterRegisterDto;
import java.util.List;

public interface CharacterService {
    void search(String name);
    void register(CharacterRegisterDto registerDto);
    List<Character> getAllCharacterList();
}
