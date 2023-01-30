package ru.veretennikov.testing.entity.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Error> handleEntityNotFoundException(EntityNotFoundException ex) {
        log.error(format("Сущность не найдена: %s", ex.getMessage()), ex);
        Error error = Error.builder()
                .message(ex.getMessage())
                .timestamp(OffsetDateTime.now())
                .type(ex.getClass().getSimpleName())
                .build();
        return ResponseEntity
                .status(NOT_FOUND)
                .body(error);
    }

}
