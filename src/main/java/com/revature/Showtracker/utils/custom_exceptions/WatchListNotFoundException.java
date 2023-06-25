package com.revature.Showtracker.utils.custom_exceptions;

public class WatchListNotFoundException extends RuntimeException{
    public WatchListNotFoundException(String message){
        super(message);
    }
}
