package com.github.nduyhai.cheatsheet.adapter.out.jdbc;

import com.github.nduyhai.cheatsheet.application.port.LanguageRepository;
import com.github.nduyhai.cheatsheet.domain.Language;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LanguageRepositoryAdapter implements LanguageRepository {
  private final LanguageJdbcRepository languageJdbcRepository;

  @Override
  public Optional<Language> findByName(String name) {
    return this.languageJdbcRepository.findByName(name).map(LanguageEntity::asLanguage);
  }
}
