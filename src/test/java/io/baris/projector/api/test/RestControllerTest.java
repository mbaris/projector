package io.baris.projector.api.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.mockito.MockitoAnnotations;

public abstract class RestControllerTest {

  protected static ObjectMapper objectMapper;

  @Before
  public void init() {

    MockitoAnnotations.initMocks(this);

    objectMapper = new ObjectMapper();
  }

}
