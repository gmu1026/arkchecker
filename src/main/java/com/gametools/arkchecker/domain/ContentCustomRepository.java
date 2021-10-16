package com.gametools.arkchecker.domain;

import java.util.List;

public interface ContentCustomRepository {
    List<Content> findAllByRequiredLevel(Integer battleLevel);
}
