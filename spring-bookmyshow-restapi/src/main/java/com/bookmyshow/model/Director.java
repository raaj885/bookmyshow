package com.bookmyshow.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
public class Director {
    @Id
    @GeneratedValue(generator = "director_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "booking_seq", sequenceName = "director_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "directorid")
    Integer directorId;

    @Column(name = "directionname",length = 30)
    String directorName;

    Integer moviesCount;

    @OneToMany(fetch = FetchType.EAGER)
    Set<Movie> movies;
    /**
     *
     * @param directorName
     * @param moviesCount
     */
    public Director(String directorName, Integer moviesCount) {
        this.directorName = directorName;
        this.moviesCount = moviesCount;

    }
}
