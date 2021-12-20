package com.bookmyshow;

import com.bookmyshow.model.*;
import com.bookmyshow.repository.ITheatreRepository;
import com.bookmyshow.service.IBookingService;
import com.bookmyshow.service.IGenreService;
import com.bookmyshow.service.IMovieService;
import com.bookmyshow.service.ITheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringBookmyshowRestapiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBookmyshowRestapiApplication.class, args);
    }

    @Autowired
    IBookingService bookingService;


    @Autowired
    IMovieService movieService;


    @Autowired
    ITheatreService theatreService;

    @Autowired
    IGenreService genreService;

    @Override
    public void run(String... args) throws Exception {
       // Genre genre1 = new Genre("scifi");
        //Genre genre2 = new Genre("fantasy");

        Genre genre1 =genreService.getById(8);
       // Genre genre2 =genreService.getById(5);

        Set<Genre> genres = new HashSet<>(Arrays.asList(genre1));

        Director director = new Director("tanu", 20);


       // Theatre theatres1 = new Theatre("pvr", "madhapur", "hyderabad", 4.0, 120);
        //Theatre theatres2 = new Theatre("inox", "hitech city", "hyderabad", 4.6, 100);
        Theatre theatres2= theatreService.getById(2);
        Theatre theatres3= theatreService.getById(6);
        Theatre theatres4= theatreService.getById(5);


        // Theatre theatres3 = new Theatre("AMB", "tinfactory", "bangalore", 4.9, 250);

        Set<Theatre> theatres = new HashSet<>(Arrays.asList(theatres2,theatres3,theatres4));

        Details details = new Details(1.0, "100 Crore", "parambrata", "bengali");

        Movie movie = new Movie("antardhaan", genres, director, theatres, details);
        //movieService.addMovie(movie);

        String stringDate = "26-12-2021 22:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime showTime = LocalDateTime.parse(stringDate, formatter);
        LocalDateTime bookingTime = LocalDateTime.now();
        Seat seat1 = new Seat("B21");
        Seat seat2 = new Seat("B22");
        Seat seat3 = new Seat("B23");

        Set<Seat> seats = new HashSet<>(Arrays.asList(seat1, seat2,seat3));
        double totalPrice = seats.size() * theatreService.getById(1).getTicketPrice();
        Booking booking = new Booking(bookingTime, showTime, seats, totalPrice, theatreService.getById(1), movieService.getById(4));
        bookingService.addBooking(booking);
        //System.out.println(movieService.getByGenre(");
        //System.out.println(genreService.getById(1));


    }
}
