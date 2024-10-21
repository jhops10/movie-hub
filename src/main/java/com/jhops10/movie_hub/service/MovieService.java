package com.jhops10.movie_hub.service;

import com.jhops10.movie_hub.entity.Movie;
import com.jhops10.movie_hub.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> addMovieList(List<Movie> movieList) {
        return movieRepository.saveAll(movieList);
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }



}
