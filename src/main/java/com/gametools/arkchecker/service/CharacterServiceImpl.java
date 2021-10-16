package com.gametools.arkchecker.service;

import com.gametools.arkchecker.domain.Character;
import com.gametools.arkchecker.domain.CharacterRepository;
import com.gametools.arkchecker.domain.dto.CharacterRegisterDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CharacterServiceImpl implements CharacterService {
    private final CharacterRepository characterRepository;

    @Override
    public void search(String name) {

    }

    @Override
    public void register(CharacterRegisterDto registerDto) {
        characterRepository.save(registerDto.toEntity());
    }

    @Override
    public List<Character> getAllCharacterList() {
        return characterRepository.findAll();
    }
}
