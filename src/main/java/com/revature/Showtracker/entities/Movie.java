package com.revature.Showtracker.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Reference;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    private String id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrop;

    @ManyToMany(mappedBy = "unwatchedMovies", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<WatchList> watchLists;

    @ManyToMany(mappedBy = "watchedMovies", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<WatchHistory> watchHistories;

    @OneToMany
    @JsonManagedReference
    private Set<Review> review;

}
