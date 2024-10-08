package com.github.nduyhai.cheatsheet.adapter.in.web;

import com.github.nduyhai.cheatsheet.domain.CheatSheets;
import java.util.List;

public record RestCheatSheets(List<RestCheatSheet> cheatSheets) {
  public static RestCheatSheets from(CheatSheets cheatSheets) {
    return new RestCheatSheets(
        cheatSheets.cheatSheets().stream().map(RestCheatSheet::from).toList());
  }
}
