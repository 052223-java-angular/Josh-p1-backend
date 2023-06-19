package com.revature.Showtracker.services;

import com.revature.Showtracker.dtos.request.NewWatchHistoryRequest;
import com.revature.Showtracker.entities.Movie;
import com.revature.Showtracker.entities.User;
import com.revature.Showtracker.repositories.WatchHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class WatchHistoryService {
    private final WatchHistoryRepository watchHistoryRepository;
    private final JwtTokenService jwtTokenService;

    //create list
    public void createHistory (User user) {
        //WatchHistory history = new WatchHistory( String.valueOf(UUID.randomUUID()), user);
        //Set<Movie> blankMovie = new HashSet<>();
        //history.setWatchedMovies(blankMovie);
        //persist to database
        watchHistoryRepository.saveNew(String.valueOf(UUID.randomUUID()), user.getId());
    }

    //display list
    public List<Movie> allMovies (NewWatchHistoryRequest request) {
        List<Movie> movieList = watchHistoryRepository.findAllById(request.getId());
        return movieList;
    }
    //add to list
    public void addMovie(@RequestBody NewWatchHistoryRequest request, Movie movie) {
        request.getList().add(movie);
        //add to database
        watchHistoryRepository.save(request.getUserid(), movie.getImdbId());
    }

    //remove from list
    public  void removeMovie(@RequestBody NewWatchHistoryRequest request, Movie movie) {
        request.getList().remove(movie);
        //remove from database
        watchHistoryRepository.delete(request.getUserid(), movie.getImdbId());
    }
}
