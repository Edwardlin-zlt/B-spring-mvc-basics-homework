package com.thoughtworks.capacity.gtb.mvc.exception;

public class UserAlreadyExistsException extends Throwable {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
