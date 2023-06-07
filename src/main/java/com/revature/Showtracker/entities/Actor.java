package com.revature.Showtracker.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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
@Table(name = "actors")
public class Actor {
    @Id
    private String id;

    private String name;

    private String born;

    private String died;

    @ManyToMany(mappedBy = "actors")
    private Set<Movie> movies;
}
