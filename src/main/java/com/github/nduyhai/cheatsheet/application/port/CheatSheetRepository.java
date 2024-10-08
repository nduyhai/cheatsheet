package com.github.nduyhai.cheatsheet.application.port;

import com.github.nduyhai.cheatsheet.domain.CheatSheets;
import com.github.nduyhai.cheatsheet.domain.Language;

public interface CheatSheetRepository {
  CheatSheets findAll();

  CheatSheets findByLanguage(Language language);
}
