package platzi.JavaTesting.Movies.service;

import platzi.JavaTesting.Movies.data.MovieRepository;
import platzi.JavaTesting.Movies.model.Genre;
import platzi.JavaTesting.Movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre){
        return  movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMovieByLength(int length){
        return  movieRepository.findAll().stream()
                .filter(movie -> movie.getDuration() <= length).collect(Collectors.toList());
    }
}
