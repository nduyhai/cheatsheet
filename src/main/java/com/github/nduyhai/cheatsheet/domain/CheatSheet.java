package com.github.nduyhai.cheatsheet.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CheatSheet {
  private CheatSheetId id;
  private String title;
  private String description;
  private String url;
  private Category category;
  private Language language;
}
