package com.outsera;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "movies")
@Data
public class Movies {

    @Id
    @GeneratedValue
    public Long id;

    @Column(name = "release_year")
    public Integer releaseYear;

    @Column(name = "title", length = 100)
    public String title;

    @Column(name = "studios", length = 200)
    public String studios;

    @Column(name = "producers", length = 200)
    public String producers;

    @Column(name = "winner")
    public Boolean winner;

}
