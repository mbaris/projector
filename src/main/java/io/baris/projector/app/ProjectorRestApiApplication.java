package io.baris.projector.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "io.baris")
public class ProjectorRestApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProjectorRestApiApplication.class, args);
  }
}
