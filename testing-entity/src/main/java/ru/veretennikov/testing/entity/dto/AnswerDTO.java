package ru.veretennikov.testing.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

public class AnswerDTO {

//    над методами интерфейсов дописать аннотации валидации, а также документацию
    @NotNull
    @PositiveOrZero
    private interface Id { Long getId(); }
    @NotNull
    @PositiveOrZero
    private interface QuestionId { Long getQuestionId(); }
    private interface LeftPart { String getLeftPart(); }
    @NotBlank
    private interface Description { String getDescription(); }
    @NotNull
    private interface Correct { Boolean getCorrect(); }

    private interface OrderNumber { Integer getOrderNumber(); }

    private interface FullFieldSet extends
            AnswerDTO.Id,
            AnswerDTO.QuestionId,
            AnswerDTO.LeftPart,
            AnswerDTO.Description,
            AnswerDTO.Correct,
            AnswerDTO.OrderNumber {}
    private interface FieldSetForCreate extends
            AnswerDTO.QuestionId,
            AnswerDTO.LeftPart,
            AnswerDTO.Description,
            AnswerDTO.Correct,
            AnswerDTO.OrderNumber {}
    private interface FieldSetForCreatePackage extends
            AnswerDTO.LeftPart,
            AnswerDTO.Description,
            AnswerDTO.Correct,
            AnswerDTO.OrderNumber {}
    private interface FieldSetForUpdate extends
            AnswerDTO.LeftPart,
            AnswerDTO.Description,
            AnswerDTO.Correct,
            AnswerDTO.OrderNumber {}

    public enum Request {;
        @Data
        public static class AnswerCreateDTO implements FieldSetForCreate {
            Long questionId;
            String leftPart;
            String description;
            Boolean correct;
            Integer orderNumber;
        }
        /**
         * для пакетного добавления нескольких записей через ведущую сущность - Question.
         * т.к. на момент создания еще не будет ссылки на question, то questionId не передается
        **/
        @Data
        public static class AnswerCreatePackageDTO implements FieldSetForCreatePackage {
            String leftPart;
            String description;
            Boolean correct;
            Integer orderNumber;
        }
        @Data
        public static class AnswerUpdateDTO implements FieldSetForUpdate {
            String leftPart;
            String description;
            Boolean correct;
            Integer orderNumber;
        }
    }

    public enum Response {;
        @Data
        public static class AnswerResponseDTO implements FullFieldSet {
            Long id;
            Long questionId;
            String leftPart;
            String description;
            Boolean correct;
            Integer orderNumber;
        }
    }

}
