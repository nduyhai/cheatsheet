package com.github.nduyhai.cheatsheet.adapter.out.md;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "category")
@AllArgsConstructor
@NoArgsConstructor
public class CategoryKey implements Comparable<CategoryKey> {
  private String category;
  private String description;

  @Override
  public int compareTo(CategoryKey o) {
    return category.compareTo(o.category);
  }
}
