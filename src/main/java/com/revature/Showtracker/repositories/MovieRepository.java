package com.revature.Showtracker.repositories;


import com.revature.Showtracker.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

    Optional<Movie> findMovieById(String id);
}
