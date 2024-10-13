package com.github.nduyhai.cheatsheet.application;

import com.github.nduyhai.cheatsheet.application.port.CheatSheetGenerator;
import com.github.nduyhai.cheatsheet.application.port.CheatSheetRepository;
import com.github.nduyhai.cheatsheet.application.port.LanguageRepository;
import com.github.nduyhai.cheatsheet.domain.CheatSheet;
import com.github.nduyhai.cheatsheet.domain.CheatSheets;
import com.github.nduyhai.cheatsheet.domain.Language;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultCheatSheetService implements CheatSheetService {
  private final CheatSheetRepository cheatSheetRepository;
  private final LanguageRepository languageRepository;
  private final CheatSheetGenerator cheatSheetGenerator;

  @Override
  public CheatSheets findAll() {
    return this.cheatSheetRepository.findAll();
  }

  @Override
  public Optional<CheatSheet> findById(Long id) {
    return this.cheatSheetRepository.findById(id);
  }

  @Override
  public void generate(String language) {
    final Language lang =
        this.languageRepository.findByName(language).orElseThrow(IllegalArgumentException::new);

    final CheatSheets cheatSheets = this.cheatSheetRepository.findByLanguage(lang);

    this.cheatSheetGenerator.generate(lang, cheatSheets);
  }
}
