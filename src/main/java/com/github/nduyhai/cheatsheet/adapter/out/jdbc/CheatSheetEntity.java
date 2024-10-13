package com.github.nduyhai.cheatsheet.adapter.out.jdbc;

import com.github.nduyhai.cheatsheet.domain.CheatSheet;
import com.github.nduyhai.cheatsheet.domain.CheatSheetId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
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

  @NotNull
  @ManyToOne(cascade = jakarta.persistence.CascadeType.PERSIST, optional = false)
  @JoinColumn(nullable = false)
  private CategoryEntity category;

  @NotNull
  @ManyToOne(cascade = jakarta.persistence.CascadeType.PERSIST, optional = false)
  @JoinColumn(nullable = false)
  private LanguageEntity language;

  public CheatSheet asCheatSheet() {
    return CheatSheet.builder()
        .id(new CheatSheetId(id))
        .title(title)
        .description(description)
        .url(url)
        .category(category.asCategory())
        .language(language.asLanguage())
        .build();
  }
}
