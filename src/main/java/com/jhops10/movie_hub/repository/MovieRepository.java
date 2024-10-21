package com.jhops10.movie_hub.repository;

import com.jhops10.movie_hub.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
