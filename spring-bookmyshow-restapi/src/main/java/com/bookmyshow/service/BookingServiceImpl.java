package com.bookmyshow.service;

import com.bookmyshow.exceptions.BookingNotFoundException;
import com.bookmyshow.model.Booking;
import com.bookmyshow.repository.IBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BookingServiceImpl implements IBookingService {

    private IBookingRepository bookingRepository;

    /**
     *
     * @param bookingRepository
     */
    @Autowired
    public void setBookingRepository(IBookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    /**
     *
     * @param booking
     * @return
     */
    @Override
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    /**
     *
     * @param booking
     */
    @Override
    public void updateBooking(Booking booking) {
        bookingRepository.save(booking);

    }

    /**
     *
     * @param bookingId
     */
    @Override
    public void deleteBooking(int bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    /**
     *
     * @param bookingId
     * @return
     * @throws BookingNotFoundException
     */
    @Override
    public Booking getById(int bookingId) throws BookingNotFoundException {
        return bookingRepository.findById(bookingId).orElseThrow(() -> {
            throw new BookingNotFoundException();
        });
    }

    /**
     *
     * @return
     * @throws BookingNotFoundException
     */
    @Override
    public List<Booking> getAll() throws BookingNotFoundException {
        return bookingRepository.findAll();
    }

    /**
     *
     * @param showTime
     * @return
     * @throws BookingNotFoundException
     */
    @Override
    public List<Booking> getByShowTime(String showTime) throws BookingNotFoundException {
        String dateTime = showTime;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime showTime2 = LocalDateTime.parse(dateTime, formatter);
        List<Booking> bookings = bookingRepository.findByShowTime(showTime2);
        if (bookings.isEmpty())
            throw new BookingNotFoundException();
        return bookings;
    }

//    @Override
//    public List<Booking> getBetweenShowTimes(String startDate, String endDate) throws BookingNotFoundException {
//        String dateTime1 = startDate;
//        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate startDate1 = LocalDate.parse(dateTime1, formatter1);
//        String dateTime2 = endDate;
//        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate endDate1 = LocalDate.parse(dateTime2, formatter2);
//        List<Booking> bookings = bookingRepository.findBetweenShowTimes(startDate1,endDate1);
//        if (bookings.isEmpty())
//            throw new BookingNotFoundException();
//        return bookings;
//    }

    /**
     *
     * @param theatre
     * @return
     * @throws BookingNotFoundException
     */
    @Override
    public List<Booking> getByTheatres(String theatre) throws BookingNotFoundException {
        List<Booking> bookings = bookingRepository.findByTheatres(theatre);
        if (bookings.isEmpty())
            throw new BookingNotFoundException();
        return bookings;

    }

    /**
     *
     * @param movie
     * @return
     * @throws BookingNotFoundException
     */
    @Override
    public List<Booking> getByMovies(String movie) throws BookingNotFoundException {
        List<Booking> bookings = bookingRepository.findByMovies(movie);
        if (bookings.isEmpty())
            throw new BookingNotFoundException();
        return bookings;

    }

    /**
     *
     * @param movie
     * @param showTime
     * @return
     * @throws BookingNotFoundException
     */
    @Override
    public List<Booking> getByMoviesAndShowTime(String movie, String showTime) throws BookingNotFoundException {
        String dateTime = showTime;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime showTime2 = LocalDateTime.parse(dateTime, formatter);
        List<Booking> bookings = bookingRepository.findByMoviesAndShowTime(movie, showTime2);
        if (bookings.isEmpty())
            throw new BookingNotFoundException();
        return bookings;
    }
}
