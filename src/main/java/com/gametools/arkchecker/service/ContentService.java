package com.gametools.arkchecker.service;

import com.gametools.arkchecker.domain.Content;
import com.gametools.arkchecker.domain.dto.ContentRegisterRequestDto;
import java.util.List;

public interface ContentService {
    void register(ContentRegisterRequestDto requestDto);
    List<Content> getAllContentList();
    List<Content> getRecommendList(String characterName);
}
