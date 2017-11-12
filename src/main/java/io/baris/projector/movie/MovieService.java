package io.baris.projector.movie;

import io.baris.projector.exception.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  @Autowired
  private MovieRepository movieRepository;

  public List<Movie> getAllMovies(){
    return movieRepository.findAllMovies();
  }

  public Movie getMovie(String id){
    return movieRepository.findMovieById(id).orElseThrow(()-> new EntityNotFoundException(Movie.class));
  }

  public Movie getMovieWithTitle(String title){
    return movieRepository.findMovieById(title).orElseThrow(()-> new EntityNotFoundException(Movie.class));
  }

  public Movie addMovie(Movie movie){
    return movieRepository.saveMovie(movie);
  }

  public Movie removeMovie(String id){
    return movieRepository.removeMovieById(id).orElseThrow(()-> new EntityNotFoundException(Movie.class));
  }

}
