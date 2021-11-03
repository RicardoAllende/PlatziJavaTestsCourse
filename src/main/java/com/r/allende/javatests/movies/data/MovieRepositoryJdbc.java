package com.r.allende.javatests.movies.data;

import com.r.allende.javatests.movies.model.Genre;
import com.r.allende.javatests.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class MovieRepositoryJdbc implements MovieRepository {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<Movie> movieMapper = (resultSet, i) -> new Movie(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getInt("minutes"),
            Genre.valueOf(resultSet.getString("genre"))
    );
//    private RowMapper<Movie> movieMapper = new RowMapper<Movie>() {
//        @Override
//        public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
//            return new Movie(
//                    resultSet.getInt("id"),
//                    resultSet.getString("name"),
//                    resultSet.getInt("minutes"),
//                    Genre.valueOf(resultSet.getString("genre"))
//            );
//        }
//    };

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(Integer id) {
        Object[] queryArgs = {id};
        return jdbcTemplate.queryForObject("SELECT * FROM movies where id = ?", queryArgs, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
    }

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("INSERT INTO movies(name, minutes, genre) VALUES(?,?,?)",
                movie.getName(), movie.getMinutes(), movie.getGenre().toString());
    }
}
