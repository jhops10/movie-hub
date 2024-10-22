package com.jhops10.movie_hub.service;

import com.jhops10.movie_hub.entity.Movie;
import com.jhops10.movie_hub.exceptions.MovieNotFoundException;
import com.jhops10.movie_hub.repository.MovieRepository;
import org.springframework.data.domain.Sort;
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
        Sort sortedList = Sort.by("id").ascending();
        return movieRepository.findAll(sortedList);
    }

    public Movie updateMovieById(Long id, Movie updateMovie) {
        var foundMovie = movieRepository.findById(id);

        if (foundMovie.isPresent()) {
            var movie = foundMovie.get();

            if (updateMovie.getTitle() != null) {
                movie.setTitle(updateMovie.getTitle());
            }

            if (updateMovie.getShortDescription() != null) {
                movie.setShortDescription(updateMovie.getShortDescription());
            }

            if (updateMovie.getReleaseYear() != null) {
                movie.setReleaseYear(updateMovie.getReleaseYear());
            }

            if (updateMovie.getGender() != null) {
                movie.setGender(updateMovie.getGender());
            }

            if (updateMovie.getDirector() != null) {
                movie.setDirector(updateMovie.getDirector());
            }

            return movieRepository.save(movie);
        }

        throw new MovieNotFoundException("Movie with id " + id + " not found.");
    }

    public void deleteMovieById(Long id) {
        movieRepository.deleteById(id);
    }




}
