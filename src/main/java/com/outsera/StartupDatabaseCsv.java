package com.outsera;

import io.quarkus.runtime.StartupEvent;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class StartupDatabaseCsv {

    @Inject
    EntityManager entityManager;

    @Transactional
    void onStart(@Observes StartupEvent event) {
        try (var inputStream = getClass().getResourceAsStream("/movielist.csv");
             var reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            List<String> linhas = reader.lines()
                    .skip(1)
                    .toList();

            for (String linha : linhas) {
                String[] colunas = linha.split(";");

                Movies movies = new Movies();
                movies.setReleaseYear(Integer.parseInt(colunas[0]));
                movies.setTitle(colunas[1]);
                movies.setStudios(colunas[2]);
                movies.setProducers(colunas[3]);
                movies.setWinner("yes".equalsIgnoreCase(colunas.length > 4 ? colunas[4].trim() : ""));
                entityManager.persist(movies);
            }

        } catch (Exception e) {
            Logger.getLogger(StartupDatabaseCsv.class.getName()).log(java.util.logging.Level.SEVERE, e.getMessage(), e);
            e.printStackTrace();
        }
    }
}
