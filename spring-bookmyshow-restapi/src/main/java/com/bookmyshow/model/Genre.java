package com.bookmyshow.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Genre {
    @Id
    @GeneratedValue(generator = "genre_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "genre_seq", sequenceName = "genre_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "genreid")
    private Integer genreId;

    @Column(name = "genrename", length = 20)
    private String genreName;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Movie> movies;

    /**
     * @param genreName
     */
    public Genre(String genreName) {
        this.genreName = genreName;

    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Genre{" +
                "genreName='" + genreName + '\'' +
                '}';
    }
}
