package com.revature.Showtracker.controllers;


import com.revature.Showtracker.dtos.request.NewMovieRequest;
import com.revature.Showtracker.dtos.request.NewWatchHistoryRequest;
import com.revature.Showtracker.entities.Movie;
import com.revature.Showtracker.services.JwtTokenService;
import com.revature.Showtracker.services.WatchHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/history")
public class WatchHistoryController {
    private final WatchHistoryService watchHistoryService;
    private final JwtTokenService jwtTokenService;

    //view watch history
    @PostMapping("/view")
    public ResponseEntity<List<Movie>> viewAll(@RequestBody NewWatchHistoryRequest request) {
        List<Movie> movieList = watchHistoryService.allMovies(request);
        return ResponseEntity.status(HttpStatus.OK).body(movieList);
    }

    //add movie to watch history
    @PostMapping("/add")
    public ResponseEntity<?> addMovie (@RequestBody NewWatchHistoryRequest request, Movie movie) {
        watchHistoryService.addMovie(request, movie);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //remove item from watch history
    @DeleteMapping("/delete")
    public  ResponseEntity<?> removeMovie(@RequestBody NewWatchHistoryRequest request, Movie movie) {
        watchHistoryService.removeMovie(request, movie);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
