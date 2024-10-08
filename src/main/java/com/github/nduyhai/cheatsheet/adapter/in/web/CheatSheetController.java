package com.github.nduyhai.cheatsheet.adapter.in.web;

import com.github.nduyhai.cheatsheet.application.CheatSheetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cheatsheets")
@RequiredArgsConstructor
public class CheatSheetController {
  private final CheatSheetService cheatSheetService;

  @GetMapping
  public ResponseEntity<RestCheatSheets> getAll() {
    return ResponseEntity.ok(RestCheatSheets.from(cheatSheetService.findAll()));
  }
}
