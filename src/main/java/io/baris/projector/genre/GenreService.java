package io.baris.projector.genre;

import io.baris.projector.exception.EntityNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService {

  @Autowired
  private GenreRepository genreRepository;

  public List<Genre> getAllGenres() {
    return genreRepository.findAll();
  }

  public Genre getGenre(String id) {
    Genre genre = genreRepository.findOne(id);
    if (genre == null) {
      throw new EntityNotFoundException();
    }
    return genre;
  }

  public Genre saveGenre(Genre genre) {
    return genreRepository.save(genre);
  }

  public void removeGenre(String id) {
    Genre genre = genreRepository.findOne(id);
    if (genre == null) {
      throw new EntityNotFoundException();
    }
    genreRepository.delete(id);
  }
}
