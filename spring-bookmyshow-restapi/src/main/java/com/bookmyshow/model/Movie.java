package com.bookmyshow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Movie {
    @Id
    @GeneratedValue(generator = "movie_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "movie_seq", sequenceName = "movie_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "movieid")
    private Integer movieId;

    @Column(name = "moviename", length = 30)
    private String movieName;

    @JoinTable(name = "movie_genre",
            joinColumns = @JoinColumn(name = "movieid"),
            inverseJoinColumns = @JoinColumn(name = "genreid"))
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Genre> genres;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "directorid")
    @JsonIgnore
    private Director director;


    @ManyToMany
    @JoinTable(name = "movie_theatre",
            joinColumns = @JoinColumn(name = "movieid"),
            inverseJoinColumns = @JoinColumn(name = "theatreid"))
    private Set<Theatre> theatres;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detailsid")
    private Details details;

    /**
     * @param movieName
     * @param genres
     * @param director
     * @param theatres
     * @param details
     */
    public Movie(String movieName, Set<Genre> genres, Director director, Set<Theatre> theatres, Details details) {
        this.movieName = movieName;
        this.genres = genres;
        this.director = director;
        this.theatres = theatres;
        this.details = details;
    }
}
