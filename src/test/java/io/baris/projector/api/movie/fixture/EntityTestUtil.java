package io.baris.projector.api.movie.fixture;

import io.baris.projector.movie.Movie;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class EntityTestUtil {

  public static Movie randomMovie() {
    Movie movie = new Movie();
    movie.setTitle(RandomStringUtils.randomAlphabetic(10));
    movie.setDirector(RandomStringUtils.randomAlphabetic(10));
    movie.setProducer(RandomStringUtils.randomAlphabetic(10));
    movie.setPlot(RandomStringUtils.randomAlphabetic(100));
    movie.setGenre(RandomStringUtils.randomAlphabetic(10));
    movie.setPosterImageUri("http://" + RandomStringUtils.randomAlphabetic(10) + ".com/asdas.jpg");
    movie.setYear(RandomUtils.nextInt(1940, 2020));
    return movie;
  }
}
