package com.revature.Showtracker.dtos.response;

import com.revature.Showtracker.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Principal {
    private String id;
    private String username;
    private String token;

    public Principal(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }
}
