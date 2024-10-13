package com.github.nduyhai.cheatsheet.application;

import com.github.nduyhai.cheatsheet.domain.CheatSheet;
import com.github.nduyhai.cheatsheet.domain.CheatSheets;
import java.util.Optional;

public interface CheatSheetService {

  CheatSheets findAll();

  Optional<CheatSheet> findById(Long id);

  void generate(String language);
}
