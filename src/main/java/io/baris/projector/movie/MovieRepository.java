package io.baris.projector.movie;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MovieRepository extends MongoRepository<Movie, String> {

  Movie findByTitle(String title);

}
