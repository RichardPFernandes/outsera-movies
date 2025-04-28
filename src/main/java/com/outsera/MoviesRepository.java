package com.outsera;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@ApplicationScoped
public class MoviesRepository {

    @Inject
    EntityManager entityManager;

    public List<Movies> findAllMoviesWithWinners() {
        return entityManager.createQuery("select m from Movies m where m.winner = true", Movies.class).getResultList();
    }
}
