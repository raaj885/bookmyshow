package com.bookmyshow.service;

import com.bookmyshow.exceptions.MovieNotFoundException;
import com.bookmyshow.model.Movie;

import java.util.List;

public interface IMovieService {

    Movie addMovie(Movie movie);

    void updateMovie(Movie movie);

    void deleteMovie(int movieId);


    List<Movie> getAll();

    Movie getById(int movieId) throws MovieNotFoundException;

    List<Movie> getByMovieName(String movieName) throws MovieNotFoundException;

    List<Movie> getByMovieNameAndTheatre(String movieName, String theatreName) throws MovieNotFoundException;

    List<Movie> getByMovieNameAndLocation(String movieName, String location) throws MovieNotFoundException;

    List<Movie> getByMovieNameAndCity(String movieName, String city) throws MovieNotFoundException;

    List<Movie> getByMovieNameAndTheatreRating(String movieName, double rating) throws MovieNotFoundException;

    List<Movie> getByGenre(String genre) throws MovieNotFoundException;

    List<Movie> getByGenreAndLocationAndDirector(String genre, String location, String director) throws MovieNotFoundException;


}
