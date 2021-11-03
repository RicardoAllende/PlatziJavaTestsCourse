package com.r.allende.javatests.movies.service;

import com.r.allende.javatests.movies.data.MovieRepository;
import com.r.allende.javatests.movies.model.Genre;
import com.r.allende.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//import static com.platzi.javatests.movies.model.Genre.*;
import static com.r.allende.javatests.movies.model.Genre.*;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;


import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceShould {

    @InjectMocks
    MovieService movieService;

    @Mock
    MovieRepository movieRepository;

    @Before
    public void setUp() {
        movieService = new MovieService(movieRepository);
        when(movieRepository.findAll()).thenReturn(Arrays.asList(
                new Movie(1, "Dark Knight", 152, ACTION),
                new Movie(2, "Memento", 113, THRILLER),
                new Movie(3, "There's Something About Mary", 119, COMEDY),
                new Movie(4, "Super 8", 112, THRILLER),
                new Movie(5, "Scream", 111, HORROR),
                new Movie(6, "Home Alone", 103, COMEDY),
                new Movie(7, "Matrix", 136, ACTION)
        ));
    }

    @Test
    public void returnMoviesByGenre() {
        Collection<Movie> movies = movieService.findMoviesByGenre(COMEDY);
        assertThat(movies, everyItem(hasProperty("genre", is(Genre.COMEDY))));
    }

    @Test
    public void returnMoviesByDuration() {
        int maxMinutes = 112;
        Collection<Movie> movies = movieService.findMoviesByLength(maxMinutes);
//        assertThat(movies, everyItem(hasProperty("minutes", is(Genre.COMEDY))));
        assertTrue(movies.stream().allMatch(movie -> movie.getMinutes() <= maxMinutes));
        assertThat(getMovieIds(movies), is(Arrays.asList(4, 5, 6)));
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}