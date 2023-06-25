package com.revature.Showtracker.controllers;

import com.revature.Showtracker.dtos.request.NewWatchListRequest;
import com.revature.Showtracker.entities.Movie;
import com.revature.Showtracker.services.JwtTokenService;
import com.revature.Showtracker.services.WatchListService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/watchlist")
public class WatchListController {
    private final WatchListService watchListService;
    private final JwtTokenService jwtTokenService;

    //view watch history
    @PostMapping("/view")
    public ResponseEntity<List<Movie>> viewAll(@RequestBody NewWatchListRequest request) {
        List<Movie> movieList = watchListService.allMovies(request);
        return ResponseEntity.status(HttpStatus.OK).body(movieList);
    }

    //add movie to watch history
    @PostMapping("/{userId}/watchlist/add/{movieId}")
    public ResponseEntity<?> addMovie (@PathVariable String userId, @PathVariable String id) {
        watchListService.addMovie(userId, id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //remove item from watch history
    @DeleteMapping("/{userId}/watchlist/delete/{movieId}")
    public  ResponseEntity<?> removeMovie(@PathVariable String userId, @PathVariable String id) {
        watchListService.removeMovie(userId, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
