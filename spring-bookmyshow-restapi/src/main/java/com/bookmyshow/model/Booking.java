package com.bookmyshow.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
public class Booking {

    @Id
    @GeneratedValue(generator = "booking_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "booking_seq", sequenceName = "booking_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "bookingid")
    private Integer bookingId;

    @Column(name = "bookingtime")
    private LocalDateTime bookingTime;

    @Column(name = "showtime")
    private LocalDateTime showTime;

    @JoinColumn(name = "bookingid")
    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Seat> seats;

    @Column(name = "totalprice")
    private double totalPrice;

    @JoinColumn(name = "theatreid")
    @OneToOne
    private Theatre theatre;

    @JoinColumn(name = "movieid")
    @OneToOne
    private Movie movie;

    /**
     *
     * @param bookingTime
     * @param showTime
     * @param seats
     * @param totalPrice
     * @param theatre
     * @param movie
     */
    public Booking(LocalDateTime bookingTime, LocalDateTime showTime, Set<Seat> seats, double totalPrice, Theatre theatre, Movie movie) {
        this.bookingTime = bookingTime;
        this.showTime = showTime;
        this.seats = seats;
        this.totalPrice = totalPrice;
        this.theatre = theatre;
        this.movie = movie;
    }
}
