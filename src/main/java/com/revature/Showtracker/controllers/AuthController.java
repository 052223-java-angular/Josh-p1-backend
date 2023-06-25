package com.revature.Showtracker.controllers;

import com.revature.Showtracker.dtos.request.NewUserRequest;
import com.revature.Showtracker.dtos.request.NewLoginRequest;
import com.revature.Showtracker.dtos.response.Principal;
import com.revature.Showtracker.services.UserService;
import com.revature.Showtracker.utils.custom_exceptions.ResourceConflictException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody NewUserRequest request) {
        //check username
        if (!userService.isUniqueUsername((request.getUsername()))) {
            throw new ResourceConflictException("Username is not unique");
        }
        //check if username is valid
        if(!userService.isValidUsername(request.getUsername())) {
            throw new ResourceConflictException("Username needs to be 8-20 characters and contain only letters, numbers, period [.] or underscore [_]");
        }
        //check password
        if(!userService.isValidPassword(request.getPassword())) {
            throw new ResourceConflictException("Password needs to be a minimum of 8 characters long and contain at least one number and one letter");
        }
        //password is same
        if(!userService.isSamePassword(request.getPassword(), request.getConfirmPassword())) {
            throw new ResourceConflictException("Passwords do not match");
        }

        //register the user
        userService.registerUser(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody NewLoginRequest request) {
        //call login method with userService
        Principal principal = userService.login(request);
        //jwt token creation

        //return OK and the principle object on login
        return ResponseEntity.status(HttpStatus.OK).body(principal);
    }

}