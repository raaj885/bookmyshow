package com.bookmyshow.service;

import com.bookmyshow.exceptions.MovieNotFoundException;
import com.bookmyshow.model.Movie;
import com.bookmyshow.repository.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements IMovieService{
    private IMovieRepository movieRepository;

    @Autowired
    public void setMovieRepository(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    /**
     *
     * @param movie
     * @return
     */
    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    /**
     *
     * @param movie
     */
    @Override
    public void updateMovie(Movie movie) {
        movieRepository.save(movie);
    }

    /**
     *
     * @param movieId
     */
    @Override
    public void deleteMovie(int movieId) {
         movieRepository.deleteById(movieId);

    }

    /**
     *
     * @return
     */
    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    /**
     *
     * @param movieId
     * @return
     * @throws MovieNotFoundException
     */
    @Override
    public Movie getById(int movieId) throws MovieNotFoundException {
        return movieRepository.findById(movieId).orElseThrow(()->{
            throw  new MovieNotFoundException();
        });
    }

    /**
     *
     * @param movieName
     * @return
     * @throws MovieNotFoundException
     */
    @Override
    public List<Movie> getByMovieName(String movieName) throws MovieNotFoundException {
        List<Movie> movies= movieRepository.findByMovieName(movieName);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie with name "+movieName+" not found");
        return movies;
    }

    /**
     *
     * @param movieName
     * @param theatreName
     * @return
     * @throws MovieNotFoundException
     */
    @Override
    public List<Movie> getByMovieNameAndTheatre(String movieName, String theatreName) throws MovieNotFoundException {
        List<Movie> movies= movieRepository.findByMovieNameAndTheatre(movieName,theatreName);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie with name "+movieName+" not found in theatre "+theatreName);
        return movies;
    }

    /**
     *
     * @param movieName
     * @param location
     * @return
     * @throws MovieNotFoundException
     */
    @Override
    public List<Movie> getByMovieNameAndLocation(String movieName, String location) throws MovieNotFoundException {
        List<Movie> movies= movieRepository.findByMovieNameAndLocation(movieName,location);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie with name "+movieName+" not found in "+location);
        return movies;
    }

    /**
     *
     * @param movieName
     * @param city
     * @return
     * @throws MovieNotFoundException
     */
    @Override
    public List<Movie> getByMovieNameAndCity(String movieName, String city) throws MovieNotFoundException {
        List<Movie> movies= movieRepository.findByMovieNameAndCity(movieName,city);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie with name "+movieName+" not found in "+city);
        return movies;
    }

    /**
     *
     * @param movieName
     * @param rating
     * @return
     * @throws MovieNotFoundException
     */
    @Override
    public List<Movie> getByMovieNameAndTheatreRating(String movieName, double rating) throws MovieNotFoundException {
        List<Movie> movies= movieRepository.findByMovieNameAndTheatreRating(movieName,rating);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie with name "+movieName+" not found in theatre with rating >"+rating);
        return movies;
    }

    /**
     *
     * @param genre
     * @return
     * @throws MovieNotFoundException
     */
    @Override
    public List<Movie> getByGenre(String genre) throws MovieNotFoundException {
        List<Movie> movies= movieRepository.findByGenre(genre);
        if (movies.isEmpty())
            throw new MovieNotFoundException("Movie with"+genre+" genre not found");
        return movies;
    }

    /**
     *
     * @param genre
     * @param location
     * @param director
     * @return
     * @throws MovieNotFoundException
     */
    @Override
    public List<Movie> getByGenreAndLocationAndDirector(String genre, String location, String director) throws MovieNotFoundException {
        List<Movie> movies= movieRepository.findByGenreAndLocationAndDirector(genre,location,director);
        if (movies.isEmpty())
            throw new MovieNotFoundException(genre+" genre directed by "+director+" in "+location+" not found");
        return movies;
    }


}
