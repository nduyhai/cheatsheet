package com.github.nduyhai.cheatsheet.adapter.in.web;

import com.github.nduyhai.cheatsheet.domain.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RestCategory {
  private Long id;
  private String name;
  private String description;

  public static RestCategory from(Category category) {
    return new RestCategory(category.id(), category.name(), category.description());
  }
}
