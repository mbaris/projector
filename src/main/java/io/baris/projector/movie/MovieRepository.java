package io.baris.projector.movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
class MovieRepository {

  private List<Movie> movies = new ArrayList<>(Arrays.asList(
      new Movie("The Thing"),
      new Movie("Batman")));

  public List<Movie> findAllMovies() {
    return movies;
  }

  public Optional<Movie> findMovieByTitle(String title) {
    return movies.stream().filter(movie -> movie.getTitle().equals(title)).findFirst();
  }

  public Optional<Movie> findMovieById(String id) {
    return movies.stream().filter(movie -> movie.getId().equals(id)).findFirst();
  }

  public Movie saveMovie(Movie movie) {
    movies.add(movie);
    return movie;
  }

  public Optional<Movie> removeMovieById(String id) {
    Optional<Movie> movie = movies.stream().filter(m -> m.getId().equals(id)).findFirst();
    movie.ifPresent(movies::remove);
    return movie;
  }

}
