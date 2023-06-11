package com.revature.Showtracker.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewLoginRequest {
    public String username;
    public String password;
    public String token;
}
