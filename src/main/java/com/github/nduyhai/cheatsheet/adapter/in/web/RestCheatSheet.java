package com.github.nduyhai.cheatsheet.adapter.in.web;

import com.github.nduyhai.cheatsheet.domain.CheatSheet;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RestCheatSheet {
  private Long id;
  private String title;
  private String description;
  private String url;
  private String category;
  private String language;

  public static RestCheatSheet from(CheatSheet cheatSheet) {
    return new RestCheatSheet.RestCheatSheetBuilder()
        .id(cheatSheet.getId().id())
        .title(cheatSheet.getTitle())
        .description(cheatSheet.getDescription())
        .url(cheatSheet.getUrl())
        .category(cheatSheet.getCategory().name())
        .language(cheatSheet.getLanguage().name())
        .build();
  }
}
