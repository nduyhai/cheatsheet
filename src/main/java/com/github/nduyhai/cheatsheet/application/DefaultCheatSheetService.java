package com.github.nduyhai.cheatsheet.application;

import com.github.nduyhai.cheatsheet.application.port.CheatSheetGenerator;
import com.github.nduyhai.cheatsheet.application.port.CheatSheetRepository;
import com.github.nduyhai.cheatsheet.domain.CheatSheets;
import com.github.nduyhai.cheatsheet.domain.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultCheatSheetService implements CheatSheetService {
  private final CheatSheetRepository cheatSheetRepository;
  private final CheatSheetGenerator cheatSheetGenerator;

  @Override
  public CheatSheets findAll() {
    return this.cheatSheetRepository.findAll();
  }

  @Override
  public void generate(Language language) {

    final CheatSheets cheatSheets = this.cheatSheetRepository.findByLanguage(language);

    this.cheatSheetGenerator.generate(language, cheatSheets);
  }
}
