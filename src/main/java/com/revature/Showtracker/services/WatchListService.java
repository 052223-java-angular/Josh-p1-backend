package com.revature.Showtracker.services;

import com.revature.Showtracker.dtos.request.NewWatchListRequest;
import com.revature.Showtracker.entities.Movie;
import com.revature.Showtracker.entities.User;
import com.revature.Showtracker.entities.WatchHistory;
import com.revature.Showtracker.entities.WatchList;
import com.revature.Showtracker.repositories.MovieRepository;
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
    private final MovieRepository movieRepository;
    private final JwtTokenService jwtTokenService;

    //create list
    public void createList (User user) {
        WatchList list = new WatchList( String.valueOf(UUID.randomUUID()), user);
        //persist to database
        //watchListRepository.save(String.valueOf(UUID.randomUUID()), user.getId());
        watchListRepository.save(list);
    }
    public List<Movie> allMovies (NewWatchListRequest request) {
        List<Movie> movieList = watchListRepository.findAllById(request.getId());
        return movieList;
    }
    //add to list
    public void addMovie(String userId, String id) {
        Set<Movie> listSet = null;
        WatchList list = watchListRepository.findById(userId).get();
        Movie movie = movieRepository.findById(id).get();
        listSet = list.getUnwatchedMovies();
        listSet.add(movie);
        list.setUnwatchedMovies(listSet);
        watchListRepository.save(list);
    }

    //remove from list
    public void removeMovie(String userId, String id) {
        Set<Movie> listSet = null;
        WatchList list = watchListRepository.findById(userId).get();
        Movie movie = movieRepository.findById(id).get();
        listSet = list.getUnwatchedMovies();
        listSet.remove(movie);
        list.setUnwatchedMovies(listSet);
        watchListRepository.save(list);
    }
}
