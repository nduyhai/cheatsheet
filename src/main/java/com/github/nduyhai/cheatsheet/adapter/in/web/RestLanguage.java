package com.github.nduyhai.cheatsheet.adapter.in.web;

import com.github.nduyhai.cheatsheet.domain.Language;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RestLanguage {
  private Long id;
  private String name;

  public static RestLanguage from(Language language) {
    return new RestLanguage(language.id(), language.name());
  }
}
