package io.baris.projector.api.movie.controller;

import io.baris.projector.api.movie.dto.MovieDto;
import io.baris.projector.api.response.SuccessResponse;
import io.baris.projector.movie.MovieService;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

  @Autowired
  private MovieService movieService;

  @GetMapping
  public Callable<List<MovieDto>> list() {
    return () -> movieService.getAllMovies()
        .stream()
        .map(MovieDto::new)
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  public Callable<MovieDto> getWithId(@PathVariable String id) {
    return () -> new MovieDto(movieService.getMovie(id));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Callable<MovieDto> save(@Valid @RequestBody MovieDto movieDto) {
    return () -> new MovieDto(movieService.saveMovie(movieDto.toMovie()));
  }

  @DeleteMapping("/{id}")
  public Callable<SuccessResponse> delete(@PathVariable String id) {
    return () -> {
      movieService.removeMovie(id);
      return new SuccessResponse("Entity with id: [" + id + "] deleted successfuly");
    };
  }

}
