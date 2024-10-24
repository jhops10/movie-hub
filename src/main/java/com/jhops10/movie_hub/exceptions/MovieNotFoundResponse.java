package com.jhops10.movie_hub.exceptions;

import java.time.LocalDateTime;

public record MovieNotFoundResponse(LocalDateTime timestamp,
                                    String message,
                                    String details) {
}
