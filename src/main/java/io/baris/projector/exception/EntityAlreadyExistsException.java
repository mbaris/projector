package io.baris.projector.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class EntityAlreadyExistsException extends RuntimeException {

  public EntityAlreadyExistsException(String fieldName) {
    super("Entity already exists with same " + fieldName);
  }
}
