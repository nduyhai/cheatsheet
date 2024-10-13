package com.github.nduyhai.cheatsheet.adapter.in.graphql;

import com.github.nduyhai.cheatsheet.adapter.in.web.RestCheatSheet;
import com.github.nduyhai.cheatsheet.application.CheatSheetService;
import com.github.nduyhai.cheatsheet.domain.CheatSheet;
import com.github.nduyhai.cheatsheet.domain.CheatSheetId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class CheatSheetGraphQL {
  private final CheatSheetService cheatSheetService;

  @QueryMapping
  public RestCheatSheet cheatSheetById(@Argument long id) {
    return RestCheatSheet.from(
        cheatSheetService.findById(id).orElseThrow(IllegalArgumentException::new));
  }

  @SchemaMapping(typeName = "CheatSheet", field = "owner")
  public Owner owner(RestCheatSheet restCheatSheet) {
    return new Owner("ndhai");
  }

  @MutationMapping
  public RestCheatSheet createCheatSheet(@Argument CreateCheatSheetInput req) {
    log.info("receive {}", req);
    return RestCheatSheet.from(CheatSheet.builder().id(CheatSheetId.of(2)).build());
  }
}
