package com.bookmyshow.repository;

import com.bookmyshow.exceptions.BookingNotFoundException;
import com.bookmyshow.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IBookingRepository extends JpaRepository<Booking, Integer> {
    /**
     *
     * @param showTime
     * @return
     * @throws BookingNotFoundException
     */
    @Query("from Booking b where b.showTime=?1")
    List<Booking> findByShowTime(LocalDateTime showTime) throws BookingNotFoundException;

    /**
     *
     * @param theatre
     * @return
     * @throws BookingNotFoundException
     */
    @Query("from Booking b inner join b.theatre t where t.name=?1")
    List<Booking> findByTheatres(String theatre) throws BookingNotFoundException;

    /**
     *
     * @param movie
     * @return
     * @throws BookingNotFoundException
     */
    @Query("from Booking b inner join b.movie m where m.movieName=?1")
    List<Booking> findByMovies(String movie) throws BookingNotFoundException;

    /**
     *
     * @param movie
     * @param showTime
     * @return
     * @throws BookingNotFoundException
     */
    @Query("from Booking b inner join b.movie m where m.movieName=?1 and b.showTime=?2")
    List<Booking> findByMoviesAndShowTime(String movie, LocalDateTime showTime) throws BookingNotFoundException;

//    @Query("from Booking b where b.showTime>=?1 and b.showTime=<?2")
//    List<Booking>findBetweenShowTimes(LocalDate startDate, LocalDate endDate) throws BookingNotFoundException;





}
