package io.baris.projector.api.movie.dto;

import io.baris.projector.movie.Movie;
import org.hibernate.validator.constraints.NotBlank;

public class MovieDto {

  @NotBlank
  private String title;

  public MovieDto() {
  }

  public MovieDto(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Movie toMovie() {
    return new Movie(title);
  }
}
