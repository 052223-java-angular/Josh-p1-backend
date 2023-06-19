package com.revature.Showtracker.services;

import com.revature.Showtracker.dtos.request.NewWatchListRequest;
import com.revature.Showtracker.entities.Movie;
import com.revature.Showtracker.entities.User;
import com.revature.Showtracker.repositories.WatchListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class WatchListService {
    private final WatchListRepository watchListRepository;
    private final JwtTokenService jwtTokenService;

    //create list
    public void createList (User user) {
        //WatchList list = new WatchList( String.valueOf(UUID.randomUUID()), user);
        //Set<Movie> blankMovie = new HashSet<>();
        //list.setUnwatchedMovies(blankMovie);
        //persist to database
        watchListRepository.saveNew(String.valueOf(UUID.randomUUID()), user.getId());
    }
    public List<Movie> allMovies (NewWatchListRequest request) {
        List<Movie> movieList = watchListRepository.findAllById(request.getId());
        return movieList;
    }
    //add to list
    public void addMovie(@RequestBody NewWatchListRequest request, Movie movie) {
        request.getList().add(movie);
        //add to database
        watchListRepository.save(request.getUserid(), movie.getImdbId());
    }

    //remove from list
    public void removeMovie(@RequestBody NewWatchListRequest request, Movie movie) {
        request.getList().remove(movie);
        //remove from database
        watchListRepository.delete(request.getUserid(), movie.getImdbId());
    }
}
