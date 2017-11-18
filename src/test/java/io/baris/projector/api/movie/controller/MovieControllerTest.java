package io.baris.projector.api.movie.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.baris.projector.api.movie.dto.MovieDto;
import io.baris.projector.api.movie.fixture.EntityTestUtil;
import io.baris.projector.api.response.SuccessResponse;
import io.baris.projector.api.test.RestControllerTest;
import io.baris.projector.movie.MovieService;
import io.baris.projector.movie.model.Movie;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class MovieControllerTest extends RestControllerTest {

  private static final String BASE_PATH = "/movies";

  @InjectMocks
  private MovieController movieController;

  @Mock
  private MovieService movieService;

  private MockMvc mvc;

  @Before
  public void initMockMvc() {
    mvc = MockMvcBuilders.standaloneSetup(movieController).build();
  }

  @After
  public void verifyNoMoreInteractionsWithService() {
    verifyNoMoreInteractions(movieService);
  }

  @Test
  public void listMovies() throws Exception {
    Movie movie1 = EntityTestUtil.randomMovie();
    Movie movie2 = EntityTestUtil.randomMovie();

    when(movieService.getAllMovies()).thenReturn(
        Arrays.asList(movie1, movie2));
    Object result = mvc.perform(get(BASE_PATH)
        .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andReturn().getAsyncResult();

    assertThat(result, is(instanceOf(List.class)));
    List<MovieDto> movies = (List<MovieDto>) result;
    assertThat(movies, hasSize(2));
    assertThat(movies, hasItem(new MovieDto(movie1)));
    assertThat(movies, hasItem(new MovieDto(movie2)));

    verify(movieService).getAllMovies();
  }

  @Test
  public void getMovieWithId() throws Exception {
    String randomId = UUID.randomUUID().toString();
    Movie movie = EntityTestUtil.randomMovie();
    when(movieService.getMovie(randomId)).thenReturn(movie);
    Object result = mvc.perform(get(BASE_PATH + "/" + randomId)
        .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andReturn().getAsyncResult();

    assertThat(result, is(instanceOf(MovieDto.class)));
    MovieDto movieResponse = (MovieDto) result;
    assertThat(movieResponse, is(equalTo(new MovieDto(movie))));
    verify(movieService).getMovie(randomId);
  }

  @Test
  public void getMovieWithTitle() throws Exception {
    Movie movie = EntityTestUtil.randomMovie();

    when(movieService.getMovieByTitle(movie.getTitle())).thenReturn(movie);
    Object result = mvc.perform(get(BASE_PATH + "/" + movie.getTitle() + "?identifierType=title")
        .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().isOk())
        .andReturn().getAsyncResult();

    assertThat(result, is(instanceOf(MovieDto.class)));
    MovieDto movieResponse = (MovieDto) result;
    assertThat(movieResponse, is(equalTo(new MovieDto(movie))));
    verify(movieService).getMovieByTitle(movie.getTitle());
  }

  @Test
  public void saveMovie() throws Exception {
    Movie movie = EntityTestUtil.randomMovie();
    MovieDto movieDto = new MovieDto(movie);

    Movie movieResponse = new Movie(movie);
    movieResponse.setId(RandomStringUtils.randomAlphanumeric(24));
    when(movieService.saveMovie(movie)).thenReturn(movieResponse);

    Object result = mvc.perform(post(BASE_PATH)
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(objectMapper.writeValueAsString(movieDto)))
        .andExpect(status().isCreated())
        .andReturn().getAsyncResult();

    assertThat(result, is(instanceOf(MovieDto.class)));
    assertThat(result, is(equalTo(new MovieDto(movieResponse))));
    verify(movieService).saveMovie(movie);
  }

  @Test
  public void deleteMovie() throws Exception {
    String randomId = UUID.randomUUID().toString();
    Object result = mvc.perform(delete(BASE_PATH + "/" + randomId)
        .contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(status().is2xxSuccessful())
        .andReturn().getAsyncResult();

    assertThat(result, is(instanceOf(SuccessResponse.class)));
    SuccessResponse successResponse = (SuccessResponse) result;
    assertThat(successResponse.getMessage(), containsString("deleted"));
    verify(movieService).removeMovie(randomId);
  }

}