package io.baris.projector.genre;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "genre")
public class Genre {

  @Id
  private String id;

  private String name;

  public Genre(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public Genre() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
