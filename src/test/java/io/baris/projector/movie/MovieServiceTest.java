package io.baris.projector.movie;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import io.baris.projector.api.movie.fixture.EntityTestUtil;
import io.baris.projector.exception.EntityAlreadyExistsException;
import io.baris.projector.exception.EntityNotFoundException;
import io.baris.projector.movie.model.Movie;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {

  @InjectMocks
  private MovieService movieService;

  @Mock
  private MovieRepository movieRepository;

  @Test
  public void getAllMovies() {
    Movie movie1 = EntityTestUtil.randomMovie();
    Movie movie2 = EntityTestUtil.randomMovie();

    when(movieRepository.findAll()).thenReturn(Arrays.asList(movie1, movie2));
    List<Movie> allMovies = movieService.getAllMovies();

    assertThat(allMovies, hasSize(2));
    assertThat(allMovies, hasItem(movie1));
    assertThat(allMovies, hasItem(movie2));

    verify(movieRepository, times(1)).findAll();
    verifyNoMoreInteractions(movieRepository);
  }

  @Test
  public void getMovie() {
    Movie movie = EntityTestUtil.randomMovie();
    String id = RandomStringUtils.randomAlphanumeric(24);

    when(movieRepository.findOne(id)).thenReturn(movie);
    Movie movieResponse = movieService.getMovie(id);

    assertThat(movie, is(equalTo(movieResponse)));
    verify(movieRepository).findOne(id);
    verifyNoMoreInteractions(movieRepository);
  }

  @Test
  public void getNonExistingMovieThrowsException() {
    String id = RandomStringUtils.randomAlphanumeric(24);
    when(movieRepository.findOne(id)).thenReturn(null);

    try {
      movieService.getMovie(id);
      fail("movieService.getMovie should have thrown an exception");
    } catch (EntityNotFoundException e) {
      assertThat(e.getMessage(), containsString("Entity does not exist"));
    }

    verify(movieRepository).findOne(id);
    verifyNoMoreInteractions(movieRepository);
  }

  @Test
  public void getMovieByTitle() {
    Movie movie = EntityTestUtil.randomMovie();
    String title = RandomStringUtils.randomAlphanumeric(10);

    when(movieRepository.findByTitle(title)).thenReturn(movie);
    Movie movieResponse = movieService.getMovieByTitle(title);

    assertThat(movie, is(equalTo(movieResponse)));
    verify(movieRepository).findByTitle(title);
    verifyNoMoreInteractions(movieRepository);
  }

  @Test
  public void getNonExistingMovieWithTitleThrowsException() {
    String title = RandomStringUtils.randomAlphanumeric(10);
    when(movieRepository.findByTitle(title)).thenReturn(null);

    try {
      movieService.getMovieByTitle(title);
      fail("movieService.getMovieByTitle should have thrown an exception");
    } catch (EntityNotFoundException e) {
      assertThat(e.getMessage(), containsString("Entity does not exist"));
    }

    verify(movieRepository).findByTitle(title);
    verifyNoMoreInteractions(movieRepository);
  }

  @Test
  public void saveMovie() {
    Movie movie = EntityTestUtil.randomMovie();
    Movie expectedResponse = new Movie(movie);
    expectedResponse.setId(RandomStringUtils.randomAlphanumeric(24));
    when(movieRepository.save(movie)).thenReturn(expectedResponse);
    when(movieRepository.findByTitle(movie.getTitle())).thenReturn(null);

    Movie movieResponse = movieService.saveMovie(movie);

    assertThat(movieResponse, is(equalTo(expectedResponse)));

    verify(movieRepository).findByTitle(movie.getTitle());
    verify(movieRepository).save(movie);
    verifyNoMoreInteractions(movieRepository);
  }

  @Test
  public void saveMovieWithExistingTitleThrowsException() {
    Movie existingMovie = EntityTestUtil.randomMovie();
    Movie movie = EntityTestUtil.randomMovie();
    movie.setTitle(existingMovie.getTitle());
    when(movieRepository.findByTitle(existingMovie.getTitle())).thenReturn(existingMovie);

    try {
      movieService.saveMovie(movie);
      fail("movieService.saveMovie should have thrown an exception");
    } catch (EntityAlreadyExistsException e) {
      assertThat(e.getMessage(), containsString("Entity already exists with same title"));
    }

    verify(movieRepository).findByTitle(movie.getTitle());
    verifyNoMoreInteractions(movieRepository);
  }

  @Test
  public void removeMovie() {
    Movie movie = EntityTestUtil.randomMovie();
    String id = RandomStringUtils.randomAlphanumeric(24);
    when(movieRepository.findOne(id)).thenReturn(movie);

    movieService.removeMovie(id);

    verify(movieRepository).delete(id);
    verify(movieRepository).findOne(id);
    verifyNoMoreInteractions(movieRepository);
  }

  @Test
  public void removeNonExistingMovieThrowsException() {
    String id = RandomStringUtils.randomAlphanumeric(24);
    when(movieRepository.findOne(id)).thenReturn(null);

    try {
      movieService.removeMovie(id);
      fail("movieService.removeMovie should have thrown an exception");
    } catch (EntityNotFoundException e) {
      assertThat(e.getMessage(), containsString("Entity does not exist"));
    }

    verify(movieRepository).findOne(id);
    verifyNoMoreInteractions(movieRepository);
  }

}