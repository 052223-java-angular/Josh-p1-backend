package com.revature.Showtracker.services;

import com.revature.Showtracker.dtos.request.NewUserRequest;
import com.revature.Showtracker.dtos.request.NewLoginRequest;
import com.revature.Showtracker.dtos.response.Principal;
import com.revature.Showtracker.entities.User;
import com.revature.Showtracker.repositories.UserRepository;
import com.revature.Showtracker.utils.custom_exceptions.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public boolean isUniqueUsername(String username) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        return userOpt.isEmpty();
    }

    public boolean isValidUsername(String username) {
        return username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
    }

    public boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
    }

    public boolean isSamePassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    public User registerUser (NewUserRequest request) {
        //hash password
        String hash = BCrypt.hashpw(request.getPassword(), BCrypt.gensalt());
        //create new user
        User newUser = new User(request.getUsername(), hash);
        //save user
        return userRepository.save(newUser);
    }

    public Principal login (NewLoginRequest request) {
        Optional<User> userOpt = userRepository.findByUsername(request.getUsername());

        if (!userOpt.isEmpty()) {
            User validUser = userOpt.get();
            if( BCrypt.checkpw(request.getPassword(), validUser.getPassword())) {
                return new Principal(validUser);
            }
        }

        throw new UserNotFoundException("Invalid username or password");
    }

}
