package com.bookmyshow.service;

import com.bookmyshow.exceptions.MovieNotFoundException;
import com.bookmyshow.exceptions.TheatreNotFoundException;
import com.bookmyshow.model.Movie;
import com.bookmyshow.model.Theatre;

import java.util.List;

public interface ITheatreService {

    Theatre addTheatre(Theatre theatre);

    void updateTheatre(Theatre theatre);

    void deleteTheatre(int theatreId);

    Theatre getById(int theatreId) throws TheatreNotFoundException;

    List<Theatre> getAll();


    List<Theatre> getByTheatreName(String theatreName) throws TheatreNotFoundException;

    List<Theatre>getByLocation(String location)throws  TheatreNotFoundException;

    List<Theatre>getByCity(String city)throws TheatreNotFoundException;

    List<Theatre>getByPriceBetween(String startPrice,String endPrice)throws TheatreNotFoundException;

    List<Theatre>getByRating(double rating)throws TheatreNotFoundException;
}
