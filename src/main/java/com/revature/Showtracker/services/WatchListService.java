package com.revature.Showtracker.services;

import com.revature.Showtracker.dtos.request.NewWatchListRequest;
import com.revature.Showtracker.entities.Movie;
import com.revature.Showtracker.entities.User;
import com.revature.Showtracker.entities.WatchHistory;
import com.revature.Showtracker.entities.WatchList;
import com.revature.Showtracker.repositories.MovieRepository;
import com.revature.Showtracker.repositories.UserRepository;
import com.revature.Showtracker.repositories.WatchListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class WatchListService {
    private final WatchListRepository watchListRepository;
    private final MovieRepository movieRepository;
    private final UserRepository userRepository;
    private final JwtTokenService jwtTokenService;

    //create list
    public WatchList createList (User user) {
        WatchList list = new WatchList( String.valueOf(UUID.randomUUID()), user);
        watchListRepository.save(list);
        return list;
    }
    public List<Movie> allMovies (NewWatchListRequest request) {
        List<Movie> movieList = watchListRepository.findAllById(request.getId());
        return movieList;
    }
    //add to list
    public void addMovie(String userId, String id) {
        Set<Movie> movieSet;

        Optional<WatchList> listOpt = watchListRepository.findByUserID(userId);
        WatchList list = listOpt.get();

        if( !listOpt.isPresent() ) {
            User user = userRepository.findById(userId).get();
            WatchList newList = createList(user);
            watchListRepository.save(newList);
            list = newList;
        }

        Optional<Movie> movieOpt = movieRepository.findById(id);
        Movie movie = movieOpt.get();
        if( !movieOpt.isPresent()) {
            Movie newMovie = new Movie(id);
            movieRepository.save(newMovie);
            movie = newMovie;
        }


        movieSet = list.getUnwatchedMovies();
        movieSet.add(movie);
        list.setUnwatchedMovies(movieSet);
        watchListRepository.save(list);
    }

    //remove from list
    public void removeMovie(String userId, String id) {
        Set<Movie> listSet;
        WatchList list = watchListRepository.findById(userId).get();
        Movie movie = movieRepository.findById(id).get();
        listSet = list.getUnwatchedMovies();
        listSet.remove(movie);
        list.setUnwatchedMovies(listSet);
        watchListRepository.save(list);
    }
}
