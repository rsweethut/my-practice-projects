package com.spring.api.validation.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException(String message)
    {
        super(message);
    }
}
