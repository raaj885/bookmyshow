package com.bookmyshow.service;

import com.bookmyshow.exceptions.BookingNotFoundException;
import com.bookmyshow.model.Booking;

import java.util.List;

public interface IBookingService {

    Booking addBooking(Booking booking);

    void updateBooking(Booking booking);

    void deleteBooking(int bookingId);

    Booking getById(int bookingId) throws BookingNotFoundException;


    List<Booking> getAll() throws BookingNotFoundException;

    List<Booking> getByShowTime(String showTime) throws BookingNotFoundException;

    List<Booking> getByTheatres(String theatre) throws BookingNotFoundException;

    List<Booking> getByMovies(String movie) throws BookingNotFoundException;

    List<Booking> getByMoviesAndShowTime(String movie, String showTime) throws BookingNotFoundException;


}
