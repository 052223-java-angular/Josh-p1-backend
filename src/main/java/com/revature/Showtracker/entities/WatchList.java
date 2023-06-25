package com.revature.Showtracker.entities;

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
@Table(name = "watch_lists")
public class WatchList {
    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "watch_lists_movies",
            joinColumns = @JoinColumn(name = "watch_lists_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "movies_id", referencedColumnName = "id")
    )
    private Set<Movie> unwatchedMovies;

    public WatchList(String id, User user) {
        this.id = id;
        this.user = user;
    }

    public void addMovie(Movie movie) {
        this.unwatchedMovies.add(movie);
    }

    public void removeMovie(Movie movie){
        this.unwatchedMovies.remove(movie);
    }
}
