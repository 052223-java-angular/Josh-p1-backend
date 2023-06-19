package com.revature.Showtracker.repositories;

import com.revature.Showtracker.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, String> {
    List<Review> findByImdbId(String imdbId);
}
