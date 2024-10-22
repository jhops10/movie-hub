package com.jhops10.movie_hub.controller;

import com.jhops10.movie_hub.entity.Movie;
import com.jhops10.movie_hub.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {

        var savedMovie = movieService.addMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.addMovie(savedMovie));

    }

    @PostMapping("/add-list")
    public ResponseEntity<List<Movie>> addMovieList(@RequestBody List<Movie> movieList) {

        if (movieList == null || movieList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        var list = movieService.addMovieList(movieList);

        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {

        var list = movieService.getAllMovies();
        return ResponseEntity.status(HttpStatus.OK).body(list);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id) {
        var movie = movieService.getMovieById(id);

        if (movie.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(movie.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable("id") Long id) {
        var movie = movieService.getMovieById(id);

        if (movie.isPresent()) {
            movieService.deleteMovieById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
