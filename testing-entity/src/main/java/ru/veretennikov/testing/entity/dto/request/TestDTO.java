package ru.veretennikov.testing.entity.dto.request;

import lombok.Value;

import java.time.LocalDate;

public class TestDTO {

//    над методами интерфейсов дописать аннотации валидации, а также документацию
    private interface Id { Long getId(); }
    private interface Name { String getName(); }
    private interface Author { String getAuthor(); }
    private interface UploadDate { LocalDate getUploadDate(); }

    private interface FullFieldSet extends TestDTO.Id, TestDTO.Name, TestDTO.Author, TestDTO.UploadDate {}
    private interface FullFieldSetWithoutId extends TestDTO.Name, TestDTO.Author, TestDTO.UploadDate {}

    public enum Request {;
        @Value
        public static class TestCreateDTO implements FullFieldSetWithoutId {
            String name;
            String author;
            LocalDate uploadDate;
        }

        @Value
        public static class TestUpdateDTO implements FullFieldSet {
            Long id;
            String name;
            String author;
            LocalDate uploadDate;
        }
    }

    public enum Response {;
        @Value
        public static class TestResponseDTO implements FullFieldSet {
            Long id;
            String name;
            String author;
            LocalDate uploadDate;
        }
    }

}

