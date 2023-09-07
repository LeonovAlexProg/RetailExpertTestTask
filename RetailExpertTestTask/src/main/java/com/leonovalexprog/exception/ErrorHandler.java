package com.leonovalexprog.exception;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {
    private final String datetimePattern = "yyyy-MM-dd HH:mm:ss";

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse integrityConstraintViolation(final EntityNotFoundException e) {
        log.warn(e.getMessage());
        return new ErrorResponse(
                HttpStatus.CONFLICT.name(),
                "Entity not found",
                e.getMessage(),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern(datetimePattern))
        );
    }
}
