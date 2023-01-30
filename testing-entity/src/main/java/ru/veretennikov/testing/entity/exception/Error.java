package ru.veretennikov.testing.entity.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@Builder
@Getter
public class Error {

    private String type;
    private String message;
    private OffsetDateTime timestamp;
    private List<SubError> subErrors;

    @Builder
    @Getter
    public static class SubError {
        private Integer code;
        private String message;
        private String path;
    }

}
