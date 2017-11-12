package io.baris.projector.movie;

import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movie")
public class Movie {

  @Id
  @Indexed
  private String id;

  @Indexed
  private String title;

  private String plot;

  private Integer year;

  private String genre;

  private String director;

  private String posterImageUri;

  private String producer;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Movie movie = (Movie) o;
    return Objects.equals(id, movie.id) &&
        Objects.equals(title, movie.title) &&
        Objects.equals(plot, movie.plot) &&
        Objects.equals(year, movie.year) &&
        Objects.equals(genre, movie.genre) &&
        Objects.equals(director, movie.director) &&
        Objects.equals(posterImageUri, movie.posterImageUri) &&
        Objects.equals(producer, movie.producer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, plot, year, genre, director, posterImageUri, producer);
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Movie{");
    sb.append("id='").append(id).append('\'');
    sb.append(", title='").append(title).append('\'');
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
