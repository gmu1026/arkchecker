package com.gametools.arkchecker.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long>, ContentCustomRepository {
    Optional<Content> findByName(String name);
}
