package io.baris.projector.api.genre.dto;

import io.baris.projector.genre.Genre;
import org.hibernate.validator.constraints.NotBlank;

public class GenreDto {

  public GenreDto() {
  }

  public GenreDto(String name) {
    this.name = name;
  }

  @NotBlank
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Genre toGenre() {
    return new Genre(name);
  }
}
