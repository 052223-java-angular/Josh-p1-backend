package com.revature.Showtracker.controllers;

import com.revature.Showtracker.dtos.request.NewReviewRequest;
import com.revature.Showtracker.entities.Review;
import com.revature.Showtracker.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class ReviewController {
    private ReviewService reviewService;

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody NewReviewRequest request) {
        return new ResponseEntity<Review>(reviewService.createReview(request), HttpStatus.CREATED);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<List<Review>> findByImdb(@PathVariable String imdbId ) {
        List<Review> reviews = reviewService.findByImdbId(imdbId);
        return ResponseEntity.status(HttpStatus.OK).body(reviews);
    }
}
