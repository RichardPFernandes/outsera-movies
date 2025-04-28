package com.outsera;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.*;

@ApplicationScoped
public class MoviesService {

    @Inject
    MoviesRepository moviesRepository;

    public Map<String, List<WinnersDTO>> getIntervalMovies() {
        List<Movies> movies = moviesRepository.findAllMoviesWithWinners();

        Map<String, List<Integer>> winnersByProducer = groupByProducer(movies);

        List<WinnersDTO> allIntervals = getAllIntervals(winnersByProducer);

        return getMaxAndMinIntervals(allIntervals);
    }

    public Map<String, List<Integer>> groupByProducer(List<Movies> movies) {
        Map<String, List<Integer>> winnersByProducer = new HashMap<>();

        for (Movies movie : movies) {
            if (movie.getProducers() == null || movie.getProducers().trim().isEmpty()) {
                continue;
            }

            String[] producers = movie.getProducers().split(",| and ");

            for (String producer : producers) {
                producer = producer.trim();
                if (!producer.isEmpty()) {
                    winnersByProducer.computeIfAbsent(producer, k -> new ArrayList<>())
                            .add(movie.getReleaseYear());
                }
            }
        }

        return winnersByProducer;
    }

    public List<WinnersDTO> getAllIntervals(Map<String, List<Integer>> winnersByProducer) {
        List<WinnersDTO> allIntervals = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : winnersByProducer.entrySet()) {
            List<Integer> years = entry.getValue();
            if (years.size() < 2) {
                continue;
            }

            Collections.sort(years);

            for (int i = 1; i < years.size(); i++) {
                int previousWin = years.get(i - 1);
                int followingWin = years.get(i);
                int interval = followingWin - previousWin;
                allIntervals.add(new WinnersDTO(entry.getKey(), interval, previousWin, followingWin));
            }
        }
        return allIntervals;
    }

    public Map<String, List<WinnersDTO>> getMaxAndMinIntervals(List<WinnersDTO> allIntervals) {
        if (allIntervals.isEmpty()) {
            return Map.of("max", List.of(), "min", List.of());
        }

        int maxInterval = allIntervals.stream().mapToInt(WinnersDTO::getInterval).max().orElseThrow();
        int minInterval = allIntervals.stream().mapToInt(WinnersDTO::getInterval).min().orElseThrow();

        List<WinnersDTO> maxList = allIntervals.stream()
                .filter(w -> w.getInterval() == maxInterval)
                .toList();

        List<WinnersDTO> minList = allIntervals.stream()
                .filter(w -> w.getInterval() == minInterval)
                .toList();

        return Map.of("max", maxList, "min", minList);
    }
}
