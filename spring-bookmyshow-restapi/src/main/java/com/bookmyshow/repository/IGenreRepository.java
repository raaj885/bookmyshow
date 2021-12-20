package com.bookmyshow.repository;

import com.bookmyshow.exceptions.GenreNotFoundException;
import com.bookmyshow.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenreRepository extends JpaRepository<Genre, Integer> {

    Genre findByGenreName(String genreName) throws GenreNotFoundException;

    Genre findByGenreId(int genreId) throws GenreNotFoundException;
}
