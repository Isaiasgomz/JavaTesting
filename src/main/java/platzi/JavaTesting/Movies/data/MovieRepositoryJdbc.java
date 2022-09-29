package platzi.JavaTesting.Movies.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import platzi.JavaTesting.Movies.model.Genre;
import platzi.JavaTesting.Movies.model.Movie;

import java.util.Collection;

public class MovieRepositoryJdbc implements MovieRepository {

   private JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {

        Object[] args ={ id };

        return jdbcTemplate.queryForObject("select * from movies where id = ?", args, movieRowMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return  jdbcTemplate.query("select * from movies",movieRowMapper);

    }

    @Override
    public void saveOrUpdate(Movie movie) {

        jdbcTemplate.update("insert into movies(name, minutes,genre) values (?,?,?)",
                movie.getName(), movie.getDuration(), movie.getGenre().toString());

    }

    private static RowMapper<Movie> movieRowMapper = (rs, rowNum) ->
            new Movie(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("minutes"),
                    Genre.valueOf(rs.getString("genre"))
            );
}
