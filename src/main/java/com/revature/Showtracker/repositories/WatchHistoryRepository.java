package com.revature.Showtracker.repositories;

import com.revature.Showtracker.entities.Movie;
import com.revature.Showtracker.entities.WatchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WatchHistoryRepository extends JpaRepository<WatchHistory, String> {
    List<Movie> findAllById(String id);

    Optional<WatchHistory> findByUserID(String userId);
}
