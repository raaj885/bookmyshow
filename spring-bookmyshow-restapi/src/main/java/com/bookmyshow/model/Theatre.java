package com.bookmyshow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Theatre {
    @Id
    @GeneratedValue(generator = "theatre_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "theatre_seq", sequenceName = "theatre_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "theatreid")
    private Integer theatreId;

    @Column(length = 30)
    private String name;

    @Column(length = 30)
    private String location;

    @Column(length = 30)
    private String city;

    private double rating;

    private double ticketPrice;

    @JsonIgnore
    @ManyToMany(mappedBy = "theatres")
    private Set<Movie> movies;

    /**
     * @param name
     * @param location
     * @param city
     * @param rating
     * @param ticketPrice
     */
    public Theatre(String name, String location, String city, double rating, double ticketPrice) {
        this.name = name;
        this.location = location;
        this.city = city;
        this.rating = rating;
        this.ticketPrice = ticketPrice;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Theatre{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", city='" + city + '\'' +
                ", rating=" + rating +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
