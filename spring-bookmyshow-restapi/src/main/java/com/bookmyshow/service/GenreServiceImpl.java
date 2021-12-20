package com.bookmyshow.service;

import com.bookmyshow.exceptions.GenreNotFoundException;
import com.bookmyshow.model.Genre;
import com.bookmyshow.repository.IGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements IGenreService {

    IGenreRepository genreRepository;

    @Autowired
    public void setGenreRepository(IGenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public Genre getById(int genreId) throws GenreNotFoundException {
        return genreRepository.findByGenreId(genreId);
    }

    @Override
    public Genre getByGenreName(String genreName) throws GenreNotFoundException {
        return genreRepository.findByGenreName(genreName);
    }
}
