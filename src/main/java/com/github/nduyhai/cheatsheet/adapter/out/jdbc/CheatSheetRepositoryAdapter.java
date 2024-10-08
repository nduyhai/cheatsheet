package com.github.nduyhai.cheatsheet.adapter.out.jdbc;

import com.github.nduyhai.cheatsheet.application.port.CheatSheetRepository;
import com.github.nduyhai.cheatsheet.domain.Category;
import com.github.nduyhai.cheatsheet.domain.CheatSheet;
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
  @Transactional
  public CheatSheet save(CheatSheet cheatSheet) {
    CheatSheetEntity entity = CheatSheetEntity.from(cheatSheet);

    entity = this.cheatSheetJdbcRepository.save(entity);

    return entity.asCheatSheet();
  }

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
        this.cheatSheetJdbcRepository.findAllByLanguage(language.name()).stream()
            .map(CheatSheetEntity::asCheatSheet)
            .toList());
  }

  @Override
  @Transactional(readOnly = true)
  public CheatSheets findByCategory(Category category) {
    return new CheatSheets(
        this.cheatSheetJdbcRepository.findAllByCategory(category.name()).stream()
            .map(CheatSheetEntity::asCheatSheet)
            .toList());
  }
}
