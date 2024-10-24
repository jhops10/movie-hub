package com.jhops10.movie_hub.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MovieNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<MovieNotFoundResponse> handleMovieNotFoundException(MovieNotFoundException exception, WebRequest request) {

        var movieNotFoundResponse = new MovieNotFoundResponse(
                LocalDateTime.now(),
                exception.getMessage(),
                request.getDescription(false)

        );

        return new ResponseEntity<>(movieNotFoundResponse, HttpStatus.NOT_FOUND);
    }
}


