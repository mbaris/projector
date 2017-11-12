package io.baris.projector.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(value = "io.baris")
@EnableMongoRepositories("io.baris")
public class ProjectorRestApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProjectorRestApiApplication.class, args);
  }
}
