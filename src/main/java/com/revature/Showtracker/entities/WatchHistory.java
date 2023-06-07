package com.revature.Showtracker.entities;

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
@Table(name = "watch_histories")
public class WatchHistory {
    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "watch_histories_movies",
            joinColumns = @JoinColumn(name = "watch_histories_id"),
            inverseJoinColumns = @JoinColumn(name = "movies_id")
    )
    private Set<Movie> watchedMovies;

}
