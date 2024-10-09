package com.github.nduyhai.cheatsheet.adapter.out.jdbc;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class CategoryEntity {

  private String category;

  public static CategoryEntity of(String category) {
    CategoryEntity entity = new CategoryEntity();
    entity.setCategory(category);
    return entity;
  }
}
