package com.github.nduyhai.cheatsheet.adapter.out.md;

import com.github.nduyhai.cheatsheet.application.port.CheatSheetGenerator;
import com.github.nduyhai.cheatsheet.domain.CheatSheet;
import com.github.nduyhai.cheatsheet.domain.CheatSheets;
import com.github.nduyhai.cheatsheet.domain.Language;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CheatSheetLogGenerator implements CheatSheetGenerator {

  @Async
  @Override
  public void generate(Language language, CheatSheets cheatSheets) {
    log.info("Generating CheatSheets Log");
    final Map<CategoryKey, List<CheatSheet>> categories =
        cheatSheets.cheatSheets().stream()
            .collect(
                Collectors.groupingBy(
                    e -> new CategoryKey(e.getCategory().name(), e.getCategory().description()),
                    TreeMap::new,
                    Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                          list.sort(Comparator.comparing(CheatSheet::getTitle));
                          return list;
                        })));

    StringBuilder sb = new StringBuilder();

    sb.append(String.format("# Awesome %s", language.name())).append("\n");

    categories.forEach(
        (category, list) -> {
          sb.append(String.format("## %s", category.getCategory()))
              .append("\n")
              .append(category.getDescription())
              .append("\n");

          for (CheatSheet cheatSheet : list) {
            sb.append(
                    String.format(
                        "* [%s](%s) - %s",
                        cheatSheet.getTitle(), cheatSheet.getUrl(), cheatSheet.getDescription()))
                .append("\n");
          }
        });

    try {
      String fileName = String.format("%s.md", language.name().toLowerCase());
      Files.writeString(Path.of(fileName), sb.toString());
    } catch (IOException ex) {
      log.error("error during write file", ex);
    }
  }
}
