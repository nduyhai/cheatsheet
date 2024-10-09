package com.github.nduyhai.cheatsheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class CheatSheetApplication {

  public static void main(String[] args) {
    SpringApplication.run(CheatSheetApplication.class, args);
  }
}
