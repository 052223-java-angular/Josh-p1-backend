package com.revature.Showtracker.services;

import com.revature.Showtracker.dtos.request.NewMovieRequest;
import com.revature.Showtracker.entities.Movie;
import com.revature.Showtracker.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieService {
    private MovieRepository movieRepository;
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> movieById (String imdbId)  {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
