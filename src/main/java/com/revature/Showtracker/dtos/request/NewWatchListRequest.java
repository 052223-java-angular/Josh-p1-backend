package com.revature.Showtracker.dtos.request;

import com.revature.Showtracker.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewWatchListRequest {
    private String id;
    private String userid;
    private String token;
    private Set<Movie> list;
}
