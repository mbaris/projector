package io.baris.projector.genre;

import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "genre")
public class Genre {

  @Id
  @Indexed
  private String id;

  @Indexed
  private String name;

  public Genre(String name) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
  }

  public Genre() {
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Genre{");
    sb.append("id='").append(id).append('\'');
    sb.append(", name='").append(name).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
