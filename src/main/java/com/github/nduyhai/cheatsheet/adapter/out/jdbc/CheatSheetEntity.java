package com.github.nduyhai.cheatsheet.adapter.out.jdbc;

import com.github.nduyhai.cheatsheet.domain.Category;
import com.github.nduyhai.cheatsheet.domain.CheatSheet;
import com.github.nduyhai.cheatsheet.domain.CheatSheetId;
import com.github.nduyhai.cheatsheet.domain.Language;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "cheat_sheet")
@Getter
@Setter
public class CheatSheetEntity implements Serializable {
  @Serial private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String description;
  private String url;
  private CategoryEntity category;
  private LanguageEntity language;

  public static CheatSheetEntity from(CheatSheet cheatSheet) {
    final CheatSheetEntity entity = new CheatSheetEntity();
    entity.setId(cheatSheet.getId().id());
    entity.setTitle(cheatSheet.getTitle());
    entity.setDescription(cheatSheet.getDescription());
    entity.setUrl(cheatSheet.getUrl());

    entity.setCategory(CategoryEntity.of(cheatSheet.getCategory().name()));
    entity.setLanguage(LanguageEntity.of(cheatSheet.getLanguage().name()));
    return entity;
  }

  public CheatSheet asCheatSheet() {
    return CheatSheet.builder()
        .id(new CheatSheetId(id))
        .title(title)
        .description(description)
        .url(url)
        .category(new Category(category.getCategory()))
        .language(new Language(language.getLanguage()))
        .build();
  }
}
