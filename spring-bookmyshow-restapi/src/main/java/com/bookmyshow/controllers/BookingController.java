package com.bookmyshow.controllers;

import com.bookmyshow.exceptions.BookingNotFoundException;
import com.bookmyshow.model.Booking;
import com.bookmyshow.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("booking-api")
public class BookingController {

    IBookingService bookingService;

    @Autowired
    public void setBookingService(IBookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/bookings")
    public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "adding new booking");
        Booking nbooking = bookingService.addBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(nbooking);
    }

    @PutMapping("/bookings")
    public ResponseEntity<Void> updateBooking(@RequestBody Booking booking) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "updating a booking");
        bookingService.updateBooking(booking);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
    }

    @DeleteMapping("/bookings/{bookingid}")
    public ResponseEntity<String> deleteBooking(@RequestBody int bookingId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", " deleting booking");
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).body("deleted");
    }

    @GetMapping("/bookings/id/{bookingid}")
    public ResponseEntity<Booking> getById(@PathVariable("bookingid") int bookingId) throws BookingNotFoundException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting booking by Id");
        Booking booking = bookingService.getById(bookingId);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(booking);
    }

    @GetMapping("/bookings")
    List<Booking> getAll() {
        return bookingService.getAll();
    }

    @GetMapping("/bookings/showtime/{showtime}")
    public ResponseEntity<List<Booking>> getByShowTime(@PathVariable("showtime") String showTime) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting booking by showtime");
        List<Booking> bookings = bookingService.getByShowTime(showTime);
        return ResponseEntity.ok().headers(headers).body(bookings);
    }

//    @GetMapping("/bookings/startdate/{startdate}/enddate/{enddate}")
//    public ResponseEntity<List<Booking>> getBetweenShowTimes(@PathVariable("startdate") String startDate, @PathVariable("enddate") String endDate) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("desc", "Getting bookings between two dates");
//        List<Booking> bookings = bookingService.getBetweenShowTimes(startDate,endDate);
//        return ResponseEntity.ok().headers(headers).body(bookings);
//    }

    @GetMapping("/bookings/theatre/{theater}")
    public ResponseEntity<List<Booking>> getByTheatres(@PathVariable("theater") String theatre) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting booking by theatre");
        List<Booking> bookings = bookingService.getByTheatres(theatre);
        return ResponseEntity.ok().headers(headers).body(bookings);
    }

    @GetMapping("/bookings/movie/{movie}")
    public ResponseEntity<List<Booking>> getByMovies(@PathVariable("movie") String movie) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting booking by movie");
        List<Booking> bookings = bookingService.getByMovies(movie);
        return ResponseEntity.ok().headers(headers).body(bookings);
    }

    @GetMapping("/bookings/movie/{movie}/showtime/{showtime}")
    ResponseEntity<List<Booking>> getByMoviesAndShowTime(@PathVariable("movie") String movie, @PathVariable("showtime") String showTime) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Getting booking by movie and showtime");
        List<Booking> bookings = bookingService.getByMoviesAndShowTime(movie, showTime);
        return ResponseEntity.ok().headers(headers).body(bookings);
    }
}
