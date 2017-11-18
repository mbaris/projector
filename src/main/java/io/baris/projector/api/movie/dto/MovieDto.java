package io.baris.projector.api.movie.dto;

import io.baris.projector.movie.model.Movie;
import java.util.Objects;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public class MovieDto {

  private String id;

  @NotBlank
  @Length(min = 1, max = 64)
  private String title;

  @Length(min = 1, max = 280)
  private String plot;

  @Min(1900)
  @Max(2100)
  private Integer year;

  @Length(min = 1, max = 280)
  private String genre;

  @Length(min = 1, max = 280)
  private String director;

  @URL
  @Length(min = 6, max = 280)
  private String posterImageUri;

  @Length(min = 1, max = 280)
  private String producer;

  public MovieDto() {
  }

  public MovieDto(Movie movie) {
    this.id = movie.getId();
    this.title = movie.getTitle();
    this.plot = movie.getPlot();
    this.year = movie.getYear();
    this.genre = movie.getGenre();
    this.director = movie.getDirector();
    this.posterImageUri = movie.getPosterImageUri();
    this.producer = movie.getProducer();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getPlot() {
    return plot;
  }

  public void setPlot(String plot) {
    this.plot = plot;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getPosterImageUri() {
    return posterImageUri;
  }

  public void setPosterImageUri(String posterImageUri) {
    this.posterImageUri = posterImageUri;
  }

  public String getProducer() {
    return producer;
  }

  public void setProducer(String producer) {
    this.producer = producer;
  }

  public Movie toMovie() {
    Movie movie = new Movie();
    movie.setTitle(title);
    movie.setPlot(plot);
    movie.setYear(year);
    movie.setGenre(genre);
    movie.setDirector(director);
    movie.setPosterImageUri(posterImageUri);
    movie.setProducer(producer);
    return movie;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MovieDto movieDto = (MovieDto) o;
    return Objects.equals(title, movieDto.title) &&
        Objects.equals(id, movieDto.id) &&
        Objects.equals(plot, movieDto.plot) &&
        Objects.equals(year, movieDto.year) &&
        Objects.equals(genre, movieDto.genre) &&
        Objects.equals(director, movieDto.director) &&
        Objects.equals(posterImageUri, movieDto.posterImageUri) &&
        Objects.equals(producer, movieDto.producer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, id, plot, year, genre, director, posterImageUri, producer);
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("MovieDto{");
    sb.append("title='").append(title).append('\'');
    sb.append(", id='").append(id).append('\'');
    sb.append(", plot='").append(plot).append('\'');
    sb.append(", year=").append(year);
    sb.append(", genre='").append(genre).append('\'');
    sb.append(", director='").append(director).append('\'');
    sb.append(", posterImageUri='").append(posterImageUri).append('\'');
    sb.append(", producer='").append(producer).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
