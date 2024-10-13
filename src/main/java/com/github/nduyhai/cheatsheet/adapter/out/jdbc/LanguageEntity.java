package com.github.nduyhai.cheatsheet.adapter.out.jdbc;

import com.github.nduyhai.cheatsheet.domain.Language;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "language")
public class LanguageEntity implements Serializable {
  @Serial private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  public Language asLanguage() {
    return new Language(this.id, this.name);
  }
}
