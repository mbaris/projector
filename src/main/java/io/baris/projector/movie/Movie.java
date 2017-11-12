package io.baris.projector.movie;

import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movie")
public class Movie {

  @Id
  private String id;

  private String title;

  public Movie() {
  }

  public Movie(String title) {
    this.id = UUID.randomUUID().toString();
    this.title = title;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  @Override
  public String toString() {
    final StringBuffer sb = new StringBuffer("Movie{");
    sb.append("id='").append(id).append('\'');
    sb.append(", title='").append(title).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
