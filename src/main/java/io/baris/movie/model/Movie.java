package io.baris.movie.model;

import java.util.Date;

public class Movie {
    public Movie() {
    }

    public Movie(String id, String name, String description, Date releaseDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    private String id;
    private String name;
    private String description;
    private Date releaseDate;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Movie{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", releaseDate=").append(releaseDate);
        sb.append('}');
        return sb.toString();
    }
}
