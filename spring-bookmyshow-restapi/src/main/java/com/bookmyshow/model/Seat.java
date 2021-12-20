package com.bookmyshow.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
public class Seat {
    @Id
    @GeneratedValue(generator = "seat_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "seat_seq", sequenceName = "seat_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "seatid")
    private Integer seatId;

    private String seats;

    /**
     *
     * @param seats
     */
    public Seat(String seats) {
        this.seats = seats;
    }
}
