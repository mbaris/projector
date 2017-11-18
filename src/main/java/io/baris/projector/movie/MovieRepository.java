package io.baris.projector.movie;

import io.baris.projector.movie.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

  Movie findByTitle(String title);

}
