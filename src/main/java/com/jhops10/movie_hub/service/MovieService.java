package com.jhops10.movie_hub.service;

import com.jhops10.movie_hub.entity.Movie;
import com.jhops10.movie_hub.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }


}
