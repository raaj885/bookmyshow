package com.bookmyshow.controllers;
import com.bookmyshow.model.Movie;
import com.bookmyshow.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie-api")
public class MovieController {
    IMovieService movieService;
    @Autowired
    public void setMovieService(IMovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "adding new movie");
        Movie nmovie = movieService.addMovie(movie);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(nmovie);
    }

    @PutMapping("/movies")
    public ResponseEntity<Void> updateMovie(@RequestBody Movie movie) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updating a movie");
        movieService.updateMovie(movie);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @DeleteMapping("/movies/{movieid}")
    public ResponseEntity<String> deleteMovie(@PathVariable("movieId") int movieId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "deleting a  movie");
        movieService.deleteMovie(movieId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("deleted");
    }

    @GetMapping("/movies")
    List<Movie> getAll() {
        return movieService.getAll();
    }

    @GetMapping("/movies/id/{movieid}")
    public ResponseEntity<Movie> getById(@PathVariable("movieid") int movieId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting movie by Id");
        Movie movie = movieService.getById(movieId);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(movie);
    }

    @GetMapping("/movies/moviename/{moviename}")
    public ResponseEntity<List<Movie>> getByMovieName(@PathVariable("moviename") String movieName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting  movie by name");
        List<Movie> movies = movieService.getByMovieName(movieName);
        return ResponseEntity.ok().headers(headers).body(movies);
    }

    @GetMapping("/movies/moviename/{moviename}/theatrename/{theatrename}")
    public ResponseEntity<List<Movie>> getByMovieNameAndTheatre(@PathVariable("moviename") String movieName, @PathVariable("theatrename") String theatreName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting  movie by name and theatre name");
        List<Movie> movies = movieService.getByMovieNameAndTheatre(movieName, theatreName);
        return ResponseEntity.ok().headers(headers).body(movies);
    }

    @GetMapping("/movies/moviename/{moviename}/location/{location}")
    public ResponseEntity<List<Movie>> getByMovieNameAndLocation(@PathVariable("moviename") String movieName,@PathVariable("location") String location) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting  movie by name and theatre location");
        List<Movie> movies = movieService.getByMovieNameAndLocation(movieName, location);
        return ResponseEntity.ok().headers(headers).body(movies);
    }

    @GetMapping("/movies/moviename/{moviename}/city/{city}")
    public ResponseEntity<List<Movie>> getByMovieNameAndCity(@PathVariable("moviename") String movieName,@PathVariable("city") String city) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting  movie by name and theatre city");
        List<Movie> movies = movieService.getByMovieNameAndCity(movieName, city);
        return ResponseEntity.ok().headers(headers).body(movies);
    }

    @GetMapping("/movies/moviename/{moviename}/rating/{rating}")
    public ResponseEntity<List<Movie>> getByMovieNameAndTheatreRating(@PathVariable("moviename") String movieName, @PathVariable("rating") double rating) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting  movie by name and theatre rating");
        List<Movie> movies = movieService.getByMovieNameAndTheatreRating(movieName, rating);
        return ResponseEntity.ok().headers(headers).body(movies);
    }

    @GetMapping("/movies/genre/{genre}")
    public ResponseEntity<List<Movie>>getByGenre(@PathVariable("genre") String genre){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting  movie by genre");
        List<Movie> movies = movieService.getByGenre(genre);
        return ResponseEntity.ok().headers(headers).body(movies);
    }

    @GetMapping("/movies/genre/{genre}/location/{location}/director/{director}")
    ResponseEntity<List<Movie>> getByGenreAndLocationAndDirector(@PathVariable("genre") String genre,@PathVariable("location")  String location,@PathVariable("director")  String director){
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting  movie by genre");
        List<Movie> movies = movieService.getByGenre(genre);
        return ResponseEntity.ok().headers(headers).body(movies);
    }
}
