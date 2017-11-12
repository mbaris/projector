package io.baris.projector.movie;

import io.baris.projector.exception.EntityAlreadyExistsException;
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
      throw new EntityNotFoundException();
    }
    return movie;
  }

  public Movie getMovieByTitle(String title) {
    Movie movie = movieRepository.findByTitle(title);
    if (movie == null) {
      throw new EntityNotFoundException();
    }
    return movie;
  }

  public Movie saveMovie(Movie movie) {
    Movie movieOnDb = movieRepository.findByTitle(movie.getTitle());
    if (movieOnDb != null) {
      throw new EntityAlreadyExistsException("title");
    }
    return movieRepository.save(movie);
  }

  public void removeMovie(String id) {
    Movie movie = movieRepository.findOne(id);
    if (movie == null) {
      throw new EntityNotFoundException();
    }
    movieRepository.delete(id);
  }

}
