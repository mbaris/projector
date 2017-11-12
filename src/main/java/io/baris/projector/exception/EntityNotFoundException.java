package io.baris.projector.exception;

public class EntityNotFoundException extends RuntimeException {
  public EntityNotFoundException(Class clazz){
    super(clazz.getCanonicalName() + " does not exist");
  }
}
