package com.github.nduyhai.cheatsheet.application;

import com.github.nduyhai.cheatsheet.domain.CheatSheets;
import com.github.nduyhai.cheatsheet.domain.Language;

public interface CheatSheetService {

  CheatSheets findAll();

  void generate(Language language);
}
