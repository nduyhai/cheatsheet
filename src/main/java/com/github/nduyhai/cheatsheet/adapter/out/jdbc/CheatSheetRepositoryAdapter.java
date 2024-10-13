package com.github.nduyhai.cheatsheet.adapter.out.jdbc;

import com.github.nduyhai.cheatsheet.application.port.CheatSheetRepository;
import com.github.nduyhai.cheatsheet.domain.CheatSheet;
import com.github.nduyhai.cheatsheet.domain.CheatSheets;
import com.github.nduyhai.cheatsheet.domain.Language;
import java.util.Optional;
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

  @Transactional(readOnly = true)
  @Override
  public Optional<CheatSheet> findById(Long id) {
    return this.cheatSheetJdbcRepository.findById(id).map(CheatSheetEntity::asCheatSheet);
  }

  @Override
  @Transactional(readOnly = true)
  public CheatSheets findByLanguage(Language language) {
    return new CheatSheets(
        this.cheatSheetJdbcRepository.findByLanguage_Id(language.id()).stream()
            .map(CheatSheetEntity::asCheatSheet)
            .toList());
  }
}
