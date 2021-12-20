package com.bookmyshow.exceptions;

import com.bookmyshow.model.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        headers.add("desc", "method not allowed");
        String path = request.getContextPath();
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.NOT_FOUND, message, path);
        return ResponseEntity.status(status).headers(headers).body(errors);

    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        headers.add("desc", "Media Type not supported");
        String path = request.getContextPath();
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.NOT_FOUND, message, path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        headers.add("desc", "Path Variable is missing");
        String path = request.getContextPath();
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.NOT_FOUND, message, path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        headers.add("desc", "Request Parameter is missing");
        String path = request.getContextPath();
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.NOT_FOUND, message, path);
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = ex.getMessage();
        headers.add("desc", "Data type mismatch");
        String path = request.getContextPath();
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.NOT_FOUND, message, path);//this is hte body for the response entity
        return ResponseEntity.status(status).headers(headers).body(errors);
    }

    @ExceptionHandler(value = MovieNotFoundException.class)
    public ResponseEntity<Object> handleMovieNotFound(MovieNotFoundException ex) {
        String message = ex.getMessage();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Movie not found");
        String path = "";
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.NOT_FOUND, message, path);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body(errors);
    }

    @ExceptionHandler(value = BookingNotFoundException.class)
    public ResponseEntity<Object> handleBookingNotFound(BookingNotFoundException ex) {
        String message = ex.getMessage();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Booking not found");
        String path = "";
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.NOT_FOUND, message, path);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body(errors);
    }

    @ExceptionHandler(value = TheatreNotFoundException.class)
    public ResponseEntity<Object> handleTheatreNotFound(TheatreNotFoundException ex) {
        String message = ex.getMessage();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc", "Theatre not found");
        String path = "";
        ApiErrors errors = new ApiErrors(LocalDateTime.now(), HttpStatus.NOT_FOUND, message, path);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(headers).body(errors);
    }
}
