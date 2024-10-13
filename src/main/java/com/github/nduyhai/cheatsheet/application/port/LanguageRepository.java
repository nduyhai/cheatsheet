package com.github.nduyhai.cheatsheet.application.port;

import com.github.nduyhai.cheatsheet.domain.Language;
import java.util.Optional;

public interface LanguageRepository {
  Optional<Language> findByName(String name);
}
