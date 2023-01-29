package ru.veretennikov.testing.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.time.LocalDate;

public class TestDTO {

//    над методами интерфейсов дописать аннотации валидации, а также документацию
    @NotNull
    @PositiveOrZero
    private interface Id { Long getId(); }
    @NotBlank
    private interface Name { String getName(); }
    @NotBlank
    private interface Author { String getAuthor(); }
    @NotNull
    @PastOrPresent
    private interface UploadDate { LocalDate getUploadDate(); }

    private interface FullFieldSet extends
            TestDTO.Id,
            TestDTO.Name,
            TestDTO.Author,
            TestDTO.UploadDate {}
    private interface FullFieldSetWithoutId extends
            TestDTO.Name,
            TestDTO.Author,
            TestDTO.UploadDate {}

    public enum Request {;
        @Data
        public static class TestCreateDTO implements FullFieldSetWithoutId {
            String name;
            String author;
            LocalDate uploadDate;
        }

        @Data
        public static class TestUpdateDTO implements FullFieldSetWithoutId {
            String name;
            String author;
            LocalDate uploadDate;
        }
    }

    public enum Response {;
        @Data
        public static class TestResponseDTO implements FullFieldSet {
            Long id;
            String name;
            String author;
            LocalDate uploadDate;
        }
    }

}
