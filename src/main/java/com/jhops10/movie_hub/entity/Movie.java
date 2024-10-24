package com.jhops10.movie_hub.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "The unique identifier of the movie", example = "1")
    private Long id;

    @Schema(description = "The title of the movie", example = "Inception")
    private String title;

    @Schema(description = "A short description of the movie", example = "A mind-bending thriller")
    private String shortDescription;

    @Schema(description = "The release year of the movie", example = "2010")
    private Integer releaseYear;

    @Schema(description = "The genre of the movie", example = "Action")
    private String gender;

    @Schema(description = "The director of the movie", example = "Christopher Nolan")
    private String director;

    public Movie() {
    }

    public Movie(Long id, String title, String shortDescription, Integer releaseYear, String gender, String director) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.releaseYear = releaseYear;
        this.gender = gender;
        this.director = director;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
