package com.revature.Showtracker.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    private String id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private WatchList watchLists;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private WatchHistory watchHistories;

    public User(String username, String password) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.password = password;
    }
}
