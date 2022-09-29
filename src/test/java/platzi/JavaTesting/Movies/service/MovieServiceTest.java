package platzi.JavaTesting.Movies.service;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import platzi.JavaTesting.Movies.data.MovieRepository;
import platzi.JavaTesting.Movies.model.Genre;
import platzi.JavaTesting.Movies.model.Movie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceTest {

    MovieService movieService;

    @Before
    public void setup(){
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION),
                        new Movie(2, "Memento", 113, Genre.THRILLER),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY),
                        new Movie(4, "Super 8", 112, Genre.THRILLER),
                        new Movie(5, "Scream", 111, Genre.HORROR),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY),
                        new Movie(7, "Matrix", 136, Genre.ACTION)
                )
        );

        movieService= new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre(){
        Collection<Movie>  movies = movieService.findMoviesByGenre(Genre.COMEDY);
        assertThat(moviesIds(movies), CoreMatchers.is(Arrays.asList(3,6)));
    }

    @Test
    public void return_movies_by_length(){
        Collection<Movie> movies = movieService.findMovieByLength(119);
        assertThat(moviesIds(movies), CoreMatchers.is(Arrays.asList(2,3,4,5,6)));
    }


    private List<Integer> moviesIds(Collection<Movie> movies){
      return   movies.stream().map(Movie:: getId).collect(Collectors.toList());
    }

}