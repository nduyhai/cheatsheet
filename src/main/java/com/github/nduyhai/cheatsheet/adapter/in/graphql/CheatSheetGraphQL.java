package com.github.nduyhai.cheatsheet.adapter.in.graphql;

import com.github.nduyhai.cheatsheet.adapter.in.web.RestCategory;
import com.github.nduyhai.cheatsheet.adapter.in.web.RestCheatSheet;
import com.github.nduyhai.cheatsheet.application.CheatSheetService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CheatSheetGraphQL {
  private final CheatSheetService cheatSheetService;

  @QueryMapping
  public RestCheatSheet cheatSheetById(@Argument long id) {
    return RestCheatSheet.from(
        cheatSheetService.findById(id).orElseThrow(IllegalArgumentException::new));
  }

  @SchemaMapping
  public RestCategory category(RestCheatSheet restCheatSheet) {
    return RestCategory.builder().build();
  }
}
