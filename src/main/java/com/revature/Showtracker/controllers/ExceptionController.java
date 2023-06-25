package com.revature.Showtracker.controllers;

import com.revature.Showtracker.utils.custom_exceptions.ResourceConflictException;
import com.revature.Showtracker.utils.custom_exceptions.UserNotFoundException;
import com.revature.Showtracker.utils.custom_exceptions.WatchHistoryNotFoundException;
import com.revature.Showtracker.utils.custom_exceptions.WatchListNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ResourceConflictException.class)
    public ResponseEntity<Map<String, Object>> handleResourceConflictException(ResourceConflictException e) {
        Map<String, Object> map = new HashMap<>();

        map.put("timestamp", new Date(System.currentTimeMillis()));
        map.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(map);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFoundException(UserNotFoundException e) {
        Map<String, Object> map = new HashMap<>();

        map.put("timestamp", new Date(System.currentTimeMillis()));
        map.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
    }

    @ExceptionHandler(WatchListNotFoundException.class)
    public  ResponseEntity<Map<String, Object>> handleWatchListNotFoundException(WatchListNotFoundException e) {
        Map<String, Object> map = new HashMap<>();

        map.put("timestamp", new Date(System.currentTimeMillis()));
        map.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }

    @ExceptionHandler(WatchHistoryNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleWatchHistoryNotFoundException(WatchHistoryNotFoundException e){
        Map<String, Object> map = new HashMap<>();

        map.put("timestamp", new Date(System.currentTimeMillis()));
        map.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(map);
    }
}
