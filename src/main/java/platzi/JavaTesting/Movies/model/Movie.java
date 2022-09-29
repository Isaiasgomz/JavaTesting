package platzi.JavaTesting.Movies.model;

import java.util.Objects;

public class Movie {
    private Integer id;
    private String name;
    private int duration;
    private Genre genre;

    public Movie(String name, int duration, Genre genre) {
        this(null,name,duration,genre);
    }

    public Movie(Integer id, String name, int duration, Genre genre) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return duration == movie.duration && Objects.equals(id, movie.id) && Objects.equals(name, movie.name) && genre == movie.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, genre);
    }
}
