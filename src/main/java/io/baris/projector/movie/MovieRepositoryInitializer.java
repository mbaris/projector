package io.baris.projector.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MovieRepositoryInitializer implements CommandLineRunner {

  @Autowired
  private MovieRepository movieRepository;

  @Override
  public void run(String... args) throws Exception {
    movieRepository.deleteAll();

    movieRepository.save(new Movie("Matrix"));
    movieRepository.save(new Movie("Leon"));
    movieRepository.save(new Movie("Lord of the Rings"));

    System.out.println("Initialized db with following items:");
    movieRepository.findAll().forEach(System.out::println);
  }
}
