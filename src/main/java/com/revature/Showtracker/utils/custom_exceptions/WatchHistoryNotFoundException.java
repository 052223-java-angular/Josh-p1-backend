package com.revature.Showtracker.utils.custom_exceptions;

public class WatchHistoryNotFoundException extends RuntimeException{
    public WatchHistoryNotFoundException(String message) {
        super(message);
    }
}
