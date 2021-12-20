package com.bookmyshow.service;

import com.bookmyshow.exceptions.GenreNotFoundException;
import com.bookmyshow.exceptions.MovieNotFoundException;
import com.bookmyshow.model.Genre;
import com.bookmyshow.model.Movie;

public interface IGenreService {

    Genre getById(int genreId)throws GenreNotFoundException;

    Genre getByGenreName(String genreName) throws GenreNotFoundException;

}
