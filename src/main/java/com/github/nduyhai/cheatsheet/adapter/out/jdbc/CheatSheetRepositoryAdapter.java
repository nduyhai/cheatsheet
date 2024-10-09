package com.github.nduyhai.cheatsheet.adapter.out.jdbc;

import com.github.nduyhai.cheatsheet.application.port.CheatSheetRepository;
import com.github.nduyhai.cheatsheet.domain.CheatSheets;
import com.github.nduyhai.cheatsheet.domain.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class CheatSheetRepositoryAdapter implements CheatSheetRepository {

  private final CheatSheetJdbcRepository cheatSheetJdbcRepository;

  @Override
  @Transactional(readOnly = true)
  public CheatSheets findAll() {
    return new CheatSheets(
        this.cheatSheetJdbcRepository.findAll().stream()
            .map(CheatSheetEntity::asCheatSheet)
            .toList());
  }

  @Override
  @Transactional(readOnly = true)
  public CheatSheets findByLanguage(Language language) {
    return new CheatSheets(
        this.cheatSheetJdbcRepository.findByLanguage_Language(language.name()).stream()
            .map(CheatSheetEntity::asCheatSheet)
            .toList());
  }
}
