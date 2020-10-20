package com.thoughtworks.capacity.gtb.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Objects;
import java.util.Set;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ErrorResult> handle(UserAlreadyExistsException ex) {
        ErrorResult errorResult = new ErrorResult(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handle(MethodArgumentNotValidException exception){
        String message = Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage();
        ErrorResult errorResult = new ErrorResult(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResult> handle(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();

        String message = "";
        for (ConstraintViolation<?> constraint : violations) {
            message = constraint.getMessage();
            break;
        }
        ErrorResult errorResult = new ErrorResult(message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

    @ExceptionHandler(WrongUsernameOrPasswordException.class)
    public ResponseEntity<ErrorResult> handle(WrongUsernameOrPasswordException ex) {
        String message = ex.getMessage();
        ErrorResult errorResult = new ErrorResult((message));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }

}
