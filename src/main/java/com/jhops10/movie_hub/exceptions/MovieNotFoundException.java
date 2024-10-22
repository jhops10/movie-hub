package com.jhops10.movie_hub.exceptions;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(String msg) {
        super(msg);
    }

    public MovieNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public MovieNotFoundException() {
        super("Movie with this id was not found");
    }
}
