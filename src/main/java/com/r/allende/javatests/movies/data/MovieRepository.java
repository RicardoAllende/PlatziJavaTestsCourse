package com.r.allende.javatests.movies.data;

import com.r.allende.javatests.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {
    Movie findById(Integer id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
}
