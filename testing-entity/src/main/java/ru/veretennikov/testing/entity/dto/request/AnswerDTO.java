package ru.veretennikov.testing.entity.dto.request;

import lombok.Value;

public class AnswerDTO {

//    над методами интерфейсов дописать аннотации валидации, а также документацию
    private interface Id { Long getId(); }
    private interface Question { ru.veretennikov.testing.entity.db.Question getQuestion(); }
    private interface LeftPart { String getLeftPart(); }
    private interface Description { String getDescription(); }
    private interface Correct { Boolean getCorrect(); }
    private interface OrderNumber { Integer getOrderNumber(); }

    private interface FullFieldSet extends AnswerDTO.Id, AnswerDTO.Question, AnswerDTO.LeftPart, AnswerDTO.Description, AnswerDTO.Correct, AnswerDTO.OrderNumber {}
    private interface FullFieldSetWithoutId extends AnswerDTO.Question, AnswerDTO.LeftPart, AnswerDTO.Description, AnswerDTO.Correct, AnswerDTO.OrderNumber {}

    public enum Request {;
        @Value
        public static class AnswerCreateDTO implements FullFieldSetWithoutId {
            ru.veretennikov.testing.entity.db.Question question;
            String leftPart;
            String description;
            Boolean correct;
            Integer orderNumber;
        }

        @Value
        public static class AnswerUpdateDTO implements FullFieldSet {
            Long id;
            ru.veretennikov.testing.entity.db.Question question;
            String leftPart;
            String description;
            Boolean correct;
            Integer orderNumber;
        }
    }

    public enum Response {;
        @Value
        public static class AnswerResponseDTO implements FullFieldSet {
            Long id;
            ru.veretennikov.testing.entity.db.Question question;
            String leftPart;
            String description;
            Boolean correct;
            Integer orderNumber;
        }
    }

}

