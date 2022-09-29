package platzi.JavaTesting.Movies.data;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DelegatingDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import platzi.JavaTesting.Movies.model.Genre;
import platzi.JavaTesting.Movies.model.Movie;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class MovieRepositoryJdbcTestIntegration {

    @Test
    public void load_all_movies() throws SQLException {

        DataSource dataSource = new DriverManagerDataSource(
                "jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        ScriptUtils.executeSqlScript(dataSource.getConnection(),
                new ClassPathResource("sql-scripts/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        MovieRepositoryJdbc movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);

        Collection<Movie> movies = movieRepositoryJdbc.findAll();

        assertThat(movies, CoreMatchers.is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )));
    }

}