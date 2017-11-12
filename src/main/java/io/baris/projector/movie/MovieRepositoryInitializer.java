package io.baris.projector.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty("production")
public class MovieRepositoryInitializer implements CommandLineRunner {

  @Autowired
  private MovieRepository movieRepository;

  @Override
  public void run(String... args) throws Exception {
    movieRepository.deleteAll();

    Movie movie1 = new Movie();
    movie1.setTitle("Matrix");
    movieRepository.save(movie1);
    Movie movie2 = new Movie();
    movie2.setTitle("Leon");
    movieRepository.save(movie2);
    Movie movie3 = new Movie();
    movie3.setTitle("Lord of the Rings");
    movieRepository.save(movie3);

    System.out.println("Initialized movies with following items:");
    movieRepository.findAll().forEach(System.out::println);
  }
}
