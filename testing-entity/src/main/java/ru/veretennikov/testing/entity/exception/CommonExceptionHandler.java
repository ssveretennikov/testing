package ru.veretennikov.testing.entity.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;

import static java.lang.String.format;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handleValidationException(MethodArgumentNotValidException ex) {
        log.error(format("Ошибка валидации: %s", ex.getMessage()), ex);
        // TODO: подумать над выводом сообщения в более читаемом формате
        Error error = Error.builder()
                .message(ex.getMessage())
                .timestamp(OffsetDateTime.now())
                .type(ex.getClass().getSimpleName())
                .build();
        return ResponseEntity
                .status(UNPROCESSABLE_ENTITY)
                .body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Error> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        log.error(format("Ошибка чтения из json: %s", ex.getMessage()), ex);
        Error error = Error.builder()
                .message(ex.getMessage())
                .timestamp(OffsetDateTime.now())
                .type(ex.getClass().getSimpleName())
                .build();
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(error);
    }

}
