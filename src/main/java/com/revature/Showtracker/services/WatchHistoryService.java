package com.revature.Showtracker.services;

import com.revature.Showtracker.dtos.request.NewWatchHistoryRequest;
import com.revature.Showtracker.entities.Movie;
import com.revature.Showtracker.entities.User;
import com.revature.Showtracker.entities.WatchHistory;
import com.revature.Showtracker.repositories.MovieRepository;
import com.revature.Showtracker.repositories.UserRepository;
import com.revature.Showtracker.repositories.WatchHistoryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
@Transactional
public class WatchHistoryService {
    private final WatchHistoryRepository watchHistoryRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final JwtTokenService jwtTokenService;

    //create list
    public WatchHistory createHistory (User user) {
        WatchHistory history = new WatchHistory( String.valueOf(UUID.randomUUID()), user);
        watchHistoryRepository.save(history);
        return history;
    }

    //display list
    public List<Movie> allMovies (NewWatchHistoryRequest request) {
        List<Movie> movieList = watchHistoryRepository.findAllById(request.getId());
        return movieList;
    }
    //add to list
    public void addMovie( String userId, String id) {
        Set<Movie> movieSet;

        Optional<WatchHistory> historyOpt = watchHistoryRepository.findByUserID(userId);
        WatchHistory history = historyOpt.get();

        if( !historyOpt.isPresent() ) {
            User user = userRepository.findById(userId).get();
            WatchHistory newHistory = createHistory(user);
            watchHistoryRepository.save(newHistory);
            history = newHistory;
        }

        Optional<Movie> movieOpt = movieRepository.findById(id);
        Movie movie = movieOpt.get();
        if( !movieOpt.isPresent()) {
            Movie newMovie = new Movie(id);
            movieRepository.save(newMovie);
            movie = newMovie;
        }

        movieSet = history.getWatchedMovies();
        movieSet.add(movie);
        history.setWatchedMovies(movieSet);

        watchHistoryRepository.save(history);
    }

    //remove from list
    public  void removeMovie(String userId, String id) {
        Set<Movie> historySet;
        WatchHistory history = watchHistoryRepository.findById(userId).get();
        Movie movie = movieRepository.findById(id).get();
        historySet = history.getWatchedMovies();
        historySet.remove(movie);
        history.setWatchedMovies(historySet);
        watchHistoryRepository.save(history);
    }
}
