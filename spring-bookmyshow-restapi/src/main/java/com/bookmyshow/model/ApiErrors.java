package com.bookmyshow.model;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ApiErrors {
    LocalDateTime timestamp;
    HttpStatus status;
    String message;
    String Path;
}
