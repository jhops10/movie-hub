package com.jhops10.movie_hub.repository;

import com.jhops10.movie_hub.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByGenderIgnoreCase(String gender);
    List<Movie> findByReleaseYear(Integer releaseYear);
}
