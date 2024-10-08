package com.github.nduyhai.cheatsheet.domain;

public record CheatSheetId(long id) {
  public static CheatSheetId of(long id) {
    return new CheatSheetId(id);
  }
}
