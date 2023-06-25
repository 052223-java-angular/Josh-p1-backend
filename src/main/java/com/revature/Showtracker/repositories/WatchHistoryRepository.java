package com.revature.Showtracker.repositories;

import com.revature.Showtracker.entities.Movie;
import com.revature.Showtracker.entities.WatchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchHistoryRepository extends JpaRepository<WatchHistory, String> {
    List<Movie> findAllById(String id);

}
