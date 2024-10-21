package com.jhops10.movie_hub.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String shortDescription;
    private Integer releaseYear;
    private String gender;
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
