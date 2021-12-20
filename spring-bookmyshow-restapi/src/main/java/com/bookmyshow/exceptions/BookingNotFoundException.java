package com.bookmyshow.exceptions;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException() {
    }

    public BookingNotFoundException(String message) {
        super(message);
    }
}
