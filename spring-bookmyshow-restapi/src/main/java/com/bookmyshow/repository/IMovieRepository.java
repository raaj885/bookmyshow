package com.bookmyshow.repository;

import com.bookmyshow.exceptions.MovieNotFoundException;
import com.bookmyshow.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    /**
     *
     * @param movieName
     * @return
     * @throws MovieNotFoundException
     */
    @Query("from Movie m where m.movieName LIKE %?1%")
    List<Movie> findByMovieName(String movieName) throws MovieNotFoundException;

    /**
     *
     * @param movieName
     * @param theatreName
     * @return
     * @throws MovieNotFoundException
     */
    @Query("from Movie m inner join m.theatres t where m.movieName=?1 and t.name=?2")
    List<Movie> findByMovieNameAndTheatre(String movieName, String theatreName) throws MovieNotFoundException;

    /**
     *
     * @param movieName
     * @param location
     * @return
     * @throws MovieNotFoundException
     */
    @Query("from Movie m inner join m.theatres t where m.movieName=?1 and t.location=?2")
    List<Movie> findByMovieNameAndLocation(String movieName, String location) throws MovieNotFoundException;

    /**
     *
     * @param movieName
     * @param city
     * @return
     * @throws MovieNotFoundException
     */
    @Query("from Movie m inner join m.theatres t where m.movieName=?1 and t.city=?2")
    List<Movie> findByMovieNameAndCity(String movieName, String city) throws MovieNotFoundException;

    /**
     *
     * @param movieName
     * @param rating
     * @return
     * @throws MovieNotFoundException
     */
    @Query("from Movie m inner join m.theatres t where m.movieName=?1 and t.rating>=?2")
    List<Movie> findByMovieNameAndTheatreRating(String movieName, double rating) throws MovieNotFoundException;

    /**
     *
     * @param genre
     * @return
     * @throws MovieNotFoundException
     */
    @Query("from Movie m inner join m.genres g where g.genreName =?1")
    List<Movie>findByGenre(String genre)throws  MovieNotFoundException;

    /**
     *
     * @param genre
     * @param location
     * @param director
     * @return
     * @throws MovieNotFoundException
     */
    @Query("from Movie m inner join m.genres g inner join m.theatres t inner join m.director d  where g.genreName=?1 and t.name=?2 and d.directorName=?3")
    List<Movie> findByGenreAndLocationAndDirector(String genre, String location, String director) throws MovieNotFoundException;


}
