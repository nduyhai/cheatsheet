package com.github.nduyhai.cheatsheet.adapter.in.graphql;

public record CreateCheatSheetInput(
    String title, String description, String url, String category, String language) {}
