package com.revature.Showtracker.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
