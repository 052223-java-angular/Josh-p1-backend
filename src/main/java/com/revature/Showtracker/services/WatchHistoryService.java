package com.revature.Showtracker.services;

import com.revature.Showtracker.dtos.request.NewWatchHistoryRequest;
import com.revature.Showtracker.entities.Movie;
import com.revature.Showtracker.entities.User;
import com.revature.Showtracker.entities.WatchHistory;
import com.revature.Showtracker.repositories.MovieRepository;
import com.revature.Showtracker.repositories.WatchHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@Service
public class WatchHistoryService {
    private final WatchHistoryRepository watchHistoryRepository;
    private final MovieRepository movieRepository;
    private final JwtTokenService jwtTokenService;

    //create list
    public void createHistory (User user) {
        WatchHistory history = new WatchHistory( String.valueOf(UUID.randomUUID()), user);
        //persist to database
        //watchHistoryRepository.save(String.valueOf(UUID.randomUUID()), user.getId());
        watchHistoryRepository.save(history);
    }

    //display list
    public List<Movie> allMovies (NewWatchHistoryRequest request) {
        List<Movie> movieList = watchHistoryRepository.findAllById(request.getId());
        return movieList;
    }
    //add to list
    public void addMovie( String userId, String id) {
        Set<Movie> historySet = null;
        WatchHistory history = watchHistoryRepository.findById(userId).get();
        Movie movie = movieRepository.findById(id).get();
        historySet = history.getWatchedMovies();
        historySet.add(movie);
        history.setWatchedMovies(historySet);
        watchHistoryRepository.save(history);
    }

    //remove from list
    public  void removeMovie(String userId, String id) {
        Set<Movie> historySet = null;
        WatchHistory history = watchHistoryRepository.findById(userId).get();
        Movie movie = movieRepository.findById(id).get();
        historySet = history.getWatchedMovies();
        historySet.remove(movie);
        history.setWatchedMovies(historySet);
        watchHistoryRepository.save(history);
    }
}
