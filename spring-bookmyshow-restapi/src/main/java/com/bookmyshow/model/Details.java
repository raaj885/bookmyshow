package com.bookmyshow.model;

import javassist.expr.Cast;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Details {
    @Id
    @GeneratedValue(generator = "details_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "details_seq", sequenceName = "details_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "detailsid")
    private Integer detailsId;

    private double rating;

    @Column(length = 20)
    private String budget;

    @Column(length = 30,name = "leadcharacter")
    private String leadCharacter;

    @Column(length = 20)
    private String language;

    /**
     *
     * @param rating
     * @param budget
     * @param leadCharacter
     * @param language
     */
    public Details(double rating, String budget, String leadCharacter, String language) {
        this.rating = rating;
        this.budget = budget;
        this.leadCharacter = leadCharacter;
        this.language = language;
    }
}
