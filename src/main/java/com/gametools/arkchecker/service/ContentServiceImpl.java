package com.gametools.arkchecker.service;

import com.gametools.arkchecker.domain.Character;
import com.gametools.arkchecker.domain.CharacterRepository;
import com.gametools.arkchecker.domain.Content;
import com.gametools.arkchecker.domain.ContentRepository;
import com.gametools.arkchecker.domain.dto.ContentRegisterRequestDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ContentServiceImpl implements ContentService {
    private final ContentRepository contentRepository;
    private final CharacterRepository characterRepository;

    @Transactional
    @Override
    public void register(ContentRegisterRequestDto requestDto) {
        contentRepository.save(requestDto.toEntity());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Content> getAllContentList() {
        return contentRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Content> getRecommendList(String characterName) {
        Character character = characterRepository.findByName(characterName)
            .orElseThrow(() -> new IllegalArgumentException("해당 캐릭터가 없습니다."));

        return contentRepository.findAllByRequiredLevel(character.getItemLevel());
    }
}
