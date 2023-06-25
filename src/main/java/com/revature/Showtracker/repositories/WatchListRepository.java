package com.revature.Showtracker.repositories;

import com.revature.Showtracker.entities.Movie;
import com.revature.Showtracker.entities.WatchList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WatchListRepository extends JpaRepository<WatchList, String> {
    List<Movie> findAllById(String id);

    Optional<WatchList> findByUserID(String userId);
}