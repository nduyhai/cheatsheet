package com.github.nduyhai.cheatsheet.adapter.out.jdbc;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageJdbcRepository extends JpaRepository<LanguageEntity, Long> {
  Optional<LanguageEntity> findByName(String language);
}
