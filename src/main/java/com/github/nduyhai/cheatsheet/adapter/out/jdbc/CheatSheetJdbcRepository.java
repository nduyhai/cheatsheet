package com.github.nduyhai.cheatsheet.adapter.out.jdbc;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheatSheetJdbcRepository extends JpaRepository<CheatSheetEntity, Long> {

  List<CheatSheetEntity> findByLanguage_Language(String language);
}
