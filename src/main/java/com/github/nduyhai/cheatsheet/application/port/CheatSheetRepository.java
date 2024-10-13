package com.github.nduyhai.cheatsheet.application.port;

import com.github.nduyhai.cheatsheet.domain.CheatSheet;
import com.github.nduyhai.cheatsheet.domain.CheatSheets;
import com.github.nduyhai.cheatsheet.domain.Language;
import java.util.Optional;

public interface CheatSheetRepository {
  CheatSheets findAll();

  Optional<CheatSheet> findById(Long id);

  CheatSheets findByLanguage(Language language);
}
