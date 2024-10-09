package com.github.nduyhai.cheatsheet.adapter.out.jdbc;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class LanguageEntity {
  private String language;

  public static LanguageEntity of(String language) {
    LanguageEntity entity = new LanguageEntity();
    entity.setLanguage(language);
    return entity;
  }
}
