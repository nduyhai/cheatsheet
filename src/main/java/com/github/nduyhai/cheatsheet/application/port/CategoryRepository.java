package com.github.nduyhai.cheatsheet.application.port;

import com.github.nduyhai.cheatsheet.domain.Category;
import java.util.Optional;

public interface CategoryRepository {
  Optional<Category> findByName(String name);
}
