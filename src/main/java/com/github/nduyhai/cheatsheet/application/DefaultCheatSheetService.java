package com.github.nduyhai.cheatsheet.application;

import com.github.nduyhai.cheatsheet.application.port.CheatSheetRepository;
import com.github.nduyhai.cheatsheet.domain.Category;
import com.github.nduyhai.cheatsheet.domain.CheatSheet;
import com.github.nduyhai.cheatsheet.domain.CheatSheets;
import com.github.nduyhai.cheatsheet.domain.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultCheatSheetService implements CheatSheetService {
  private final CheatSheetRepository cheatSheetRepository;

  @Override
  public CheatSheet save(CheatSheet cheatSheet) {
    return this.cheatSheetRepository.save(cheatSheet);
  }

  @Override
  public CheatSheets findAll() {
    return this.cheatSheetRepository.findAll();
  }

  @Override
  public CheatSheets findByLanguage(Language language) {
    return this.cheatSheetRepository.findByLanguage(language);
  }

  @Override
  public CheatSheets findByCategory(Category category) {
    return this.cheatSheetRepository.findByCategory(category);
  }
}
