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
  private RestCategory category;
  private RestLanguage language;

  public static RestCheatSheet from(CheatSheet cheatSheet) {
    return new RestCheatSheet.RestCheatSheetBuilder()
        .id(cheatSheet.getId().id())
        .title(cheatSheet.getTitle())
        .description(cheatSheet.getDescription())
        .url(cheatSheet.getUrl())
        .category(RestCategory.from(cheatSheet.getCategory()))
        .language(RestLanguage.from(cheatSheet.getLanguage()))
        .build();
  }
}
