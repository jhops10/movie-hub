package com.jhops10.movie_hub.controller;

import com.jhops10.movie_hub.entity.Movie;
import com.jhops10.movie_hub.exceptions.MovieNotFoundException;
import com.jhops10.movie_hub.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/movies")
@Tag(name = "Movie Hub", description = "Endpoints for managing movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    @Operation(summary = "Add a new movie", description = "Creates a new movie entry in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Movie added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {

        var savedMovie = movieService.addMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.addMovie(savedMovie));

    }


    @PostMapping("/add-list")
    @Operation(summary = "Add a list of movies", description = "Creates a new movie list in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Movies added successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<Movie>> addMovieList(@RequestBody List<Movie> movieList) {

        if (movieList == null || movieList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        var list = movieService.addMovieList(movieList);

        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }


    @GetMapping
    @Operation(summary = "Get all movies", description = "Receive a list of all films.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<Movie>> getAllMovies() {

        var list = movieService.getAllMovies();
        return ResponseEntity.status(HttpStatus.OK).body(list);

    }


    @GetMapping("/{id}")
    @Operation(summary = "Get Movie by id", description = "Receives all information about a film by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Receives successfully"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id) {
        var movie = movieService.getMovieById(id);

        if (movie.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(movie.get());
        }

        throw new MovieNotFoundException("No results found with id: " + id);
    }


    @PutMapping("/{id}")
    @Operation(summary = "Update Movie by id", description = "Update all information about a film by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Update successfully"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Movie> updateMovieById(@PathVariable("id") Long id,
                                                 @RequestBody Movie updateMovie) {

        var movie = movieService.getMovieById(id);

        if (movie.isPresent()) {
            var updatedMovie = movieService.updateMovieById(id, updateMovie);
            return ResponseEntity.status(HttpStatus.OK).body(updatedMovie);
        }

      throw new MovieNotFoundException("No results found with id: " + id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Movie by id", description = "Delete a film by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Delete successfully"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<Void> deleteMovieById(@PathVariable("id") Long id) {
        var movie = movieService.getMovieById(id);

        if (movie.isPresent()) {
            movieService.deleteMovieById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        throw new MovieNotFoundException("No results found with id: " + id);

    }


    @GetMapping("/gender/{gender}")
    @Operation(summary = "Get all movies by gender", description = "Receive a list of movies by gender")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Receive successfully"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<Movie>> findMoviesByGender(@PathVariable("gender") String gender) {
       List<Movie> movies = movieService.findMoviesByGender(gender);

       if (movies.isEmpty()) {
           throw new MovieNotFoundException("No results found for the gender: " + gender);
       }

       return ResponseEntity.ok(movies);
    }


    @GetMapping("/year/{releaseYear}")
    @Operation(summary = "Get all movies by release year", description = "Receive a list of movies by release year")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Receive successfully"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<Movie>> findMoviesByReleaseYear(@PathVariable("releaseYear") Integer releaseYear) {
        List<Movie> movies = movieService.findMoviesByReleaseYear(releaseYear);

        if (movies.isEmpty()) {
            throw new MovieNotFoundException("No results found the release year: " + releaseYear);
        }

        return ResponseEntity.ok(movies);
    }

}
