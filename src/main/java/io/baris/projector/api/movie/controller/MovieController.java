package io.baris.projector.api.movie.controller;

import io.baris.projector.api.movie.dto.MovieDto;
import io.baris.projector.movie.Movie;
import io.baris.projector.movie.MovieService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

  @Autowired
  private MovieService movieService;

  @GetMapping
  public List<Movie> list() {
    return movieService.getAllMovies();
  }

  @GetMapping("/{id}")
  public Movie getWithId(@PathVariable String id) {
    return movieService.getMovie(id);
  }

  @PostMapping
  public Movie save(@Valid @RequestBody MovieDto movieDto) {
    return movieService.saveMovie(movieDto.toMovie());
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id) {
    movieService.removeMovie(id);
  }

}
