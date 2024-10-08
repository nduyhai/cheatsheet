package com.github.nduyhai.cheatsheet.application.port;

import com.github.nduyhai.cheatsheet.domain.Category;
import com.github.nduyhai.cheatsheet.domain.CheatSheet;
import com.github.nduyhai.cheatsheet.domain.CheatSheets;
import com.github.nduyhai.cheatsheet.domain.Language;

public interface CheatSheetRepository {
  CheatSheet save(CheatSheet cheatSheet);

  CheatSheets findAll();

  CheatSheets findByLanguage(Language language);

  CheatSheets findByCategory(Category category);
}
