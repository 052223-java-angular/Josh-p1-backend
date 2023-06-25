package com.revature.Showtracker.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewReviewRequest {
    private String id;
    private String imdbId;
    private String comment;

}
