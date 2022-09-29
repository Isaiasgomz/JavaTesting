package platzi.JavaTesting.Movies.data;

import platzi.JavaTesting.Movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {

    Movie findById(long id);

    Collection<Movie> findAll();

    void saveOrUpdate(Movie movie);
}
