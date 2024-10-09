package com.github.nduyhai.cheatsheet.application.port;

import com.github.nduyhai.cheatsheet.domain.CheatSheets;
import com.github.nduyhai.cheatsheet.domain.Language;

public interface CheatSheetGenerator {
  void generate(Language language, CheatSheets cheatSheets);
}
