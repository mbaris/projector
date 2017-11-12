package io.baris.projector.genre;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface GenreRepository extends MongoRepository<Genre, String> {

}
