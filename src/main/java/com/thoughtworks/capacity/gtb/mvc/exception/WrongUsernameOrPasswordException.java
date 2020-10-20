package com.thoughtworks.capacity.gtb.mvc.exception;

public class WrongUsernameOrPasswordException extends Throwable {
    public WrongUsernameOrPasswordException(String message) {
        super(message);
    }
}
