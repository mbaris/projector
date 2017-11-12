package io.baris.projector.movie;

import io.baris.projector.exception.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  @Autowired
  private MovieRepository movieRepository;

  public List<Movie> getAllMovies() {
    return movieRepository.findAll();
  }

  public Movie getMovie(String id) {
    Movie movie = movieRepository.findOne(id);
    if (movie == null) {
      throw new EntityNotFoundException(Movie.class);
    }
    return movie;
  }

  public Movie saveMovie(Movie movie) {
    return movieRepository.save(movie);
  }

  public void removeMovie(String id) {
    Movie movie = movieRepository.findOne(id);
    if (movie == null) {
      throw new EntityNotFoundException(Movie.class);
    }
    movieRepository.delete(id);
  }

}
