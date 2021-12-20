package com.bookmyshow.repository;

import com.bookmyshow.exceptions.TheatreNotFoundException;
import com.bookmyshow.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITheatreRepository extends JpaRepository<Theatre,Integer> {
    
  @Query("from Theatre t where t.name LIKE %?1%")
  List<Theatre> findByTheatreName(String theatreName) throws TheatreNotFoundException;

    /**
     *
     * @param location
     * @return
     * @throws TheatreNotFoundException
     */
    @Query("from Theatre t where t.location=?1")
    List<Theatre> findByLocation(String location)throws  TheatreNotFoundException;

    /**
     *
     * @param city
     * @return
     * @throws TheatreNotFoundException
     */
    @Query("from Theatre t where t.city=?1")
    List<Theatre>findByCity(String city)throws TheatreNotFoundException;

    /**
     *
     * @param startPrice
     * @param endPrice
     * @return
     * @throws TheatreNotFoundException
     */
    @Query("from Theatre t where t.ticketPrice>=?1 and t.ticketPrice<=?2")
    List<Theatre>findByPriceBetween(String startPrice,String endPrice)throws TheatreNotFoundException;

    /**
     *
     * @param rating
     * @return
     * @throws TheatreNotFoundException
     */
    @Query("from Theatre t where t.rating>=?1")
    List<Theatre>findByRating(double rating) throws  TheatreNotFoundException;
}

