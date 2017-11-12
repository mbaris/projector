package io.baris.projector.api.genre.controller;

import io.baris.projector.api.genre.dto.GenreDto;
import io.baris.projector.api.response.SuccessResponse;
import io.baris.projector.genre.Genre;
import io.baris.projector.genre.GenreService;
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
@RequestMapping("/genres")
public class GenreController {

  @Autowired
  private GenreService genreService;

  @GetMapping
  public List<Genre> list() {
    return genreService.getAllGenres();
  }

  @GetMapping("/{id}")
  public Genre getWithId(@PathVariable String id) {
    return genreService.getGenre(id);
  }

  @PostMapping
  public Genre save(@Valid @RequestBody GenreDto genreDto) {
    return genreService.saveGenre(genreDto.toGenre());
  }

  @DeleteMapping("/{id}")
  public SuccessResponse delete(@PathVariable String id) {
    genreService.removeGenre(id);
    return new SuccessResponse("Entity with id: [" + id + "] deleted successfuly");
  }
}
