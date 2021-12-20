package com.bookmyshow.service;

import com.bookmyshow.exceptions.MovieNotFoundException;
import com.bookmyshow.exceptions.TheatreNotFoundException;
import com.bookmyshow.model.Movie;
import com.bookmyshow.model.Theatre;
import com.bookmyshow.repository.ITheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreServiceImpl implements ITheatreService {

    private ITheatreRepository theatreRepository;

    @Autowired
    public void setTheatreRepository(ITheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    /**
     *
     * @param theatre
     * @return
     */
    @Override
    public Theatre addTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    /**
     *
     * @param theatre
     */
    @Override
    public void updateTheatre(Theatre theatre) {
        theatreRepository.save(theatre);
    }

    /**
     *
     * @param theatreId
     */
    @Override
    public void deleteTheatre(int theatreId) {

    }

    /**
     *
     * @param theatreId
     * @return
     * @throws TheatreNotFoundException
     */
    @Override
    public Theatre getById(int theatreId) throws TheatreNotFoundException {
        return theatreRepository.findById(theatreId).orElseThrow(() -> {
            throw new TheatreNotFoundException("Theatre with id " + theatreId + " not found");
        });
    }

    @Override
    public List<Theatre> getAll() {
        return theatreRepository.findAll();
    }

    @Override
    public List<Theatre> getByTheatreName(String theatreName) throws TheatreNotFoundException {
        List<Theatre> theatres = theatreRepository.findByTheatreName(theatreName);
        if (theatres.isEmpty())
            throw new MovieNotFoundException("No theatre found with" + theatreName);
        return theatres;
    }

    /**
     *
     * @param location
     * @return
     * @throws TheatreNotFoundException
     */
    @Override
    public List<Theatre> getByLocation(String location) throws TheatreNotFoundException {
        List<Theatre> theatres = theatreRepository.findByLocation(location);
        if (theatres.isEmpty())
            throw new MovieNotFoundException("No theatre found in " + location);
        return theatres;
    }

    /**
     *
     * @param city
     * @return
     * @throws TheatreNotFoundException
     */
    @Override
    public List<Theatre> getByCity(String city) throws TheatreNotFoundException {
        List<Theatre> theatres = theatreRepository.findByCity(city);
        if (theatres.isEmpty())
            throw new MovieNotFoundException("No theatre found in " + city);
        return theatres;
    }

    /**
     *
     * @param startPrice
     * @param endPrice
     * @return
     * @throws TheatreNotFoundException
     */
    @Override
    public List<Theatre> getByPriceBetween(String startPrice, String endPrice) throws TheatreNotFoundException {
        List<Theatre> theatres = theatreRepository.findByPriceBetween(startPrice, endPrice);
        if (theatres.isEmpty())
            throw new MovieNotFoundException("No theatre found within pricerange " + startPrice + " and " + endPrice);
        return theatres;
    }

    /**
     *
     * @param rating
     * @return
     * @throws TheatreNotFoundException
     */
    @Override
    public List<Theatre> getByRating(double rating) throws TheatreNotFoundException {
        List<Theatre> theatres = theatreRepository.findByRating(rating);
        if (theatres.isEmpty())
            throw new MovieNotFoundException("No theatre found with rating greater than " + rating);
        return theatres;
    }


}
