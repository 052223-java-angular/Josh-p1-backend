package com.revature.Showtracker.services;

import com.revature.Showtracker.dtos.request.NewReviewRequest;
import com.revature.Showtracker.entities.Review;
import com.revature.Showtracker.repositories.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ReviewService {
    private ReviewRepository reviewRepository;

    public Review createReview(NewReviewRequest request) {
        Review review = new Review();
        review.setId(UUID.randomUUID());
        review.setComment(request.getComment());
        review.setImdbId(request.getImdbId());

        reviewRepository.save(review);
        return review;
    }

    public List<Review> findByImdbId(String imdbId) {
        List<Review> reviews = new ArrayList<>();

        return reviewRepository.findByImdbId(imdbId);
    }
}
