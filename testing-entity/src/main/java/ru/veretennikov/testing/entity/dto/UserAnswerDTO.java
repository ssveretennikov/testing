package ru.veretennikov.testing.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

public class UserAnswerDTO {

//    над методами интерфейсов дописать аннотации валидации, а также документацию
    @NotNull
    @PositiveOrZero
    private interface Id { Long getId(); }
    @NotNull
    @PositiveOrZero
    private interface PassedTestId { Long getPassedTestId(); }
    @NotNull
    @PositiveOrZero
    private interface QuestionId { Long getQuestionId(); }
    @NotNull
    @PositiveOrZero
    private interface AnswerId { Long getAnswerId(); }
    private interface LeftPart { String getLeftPart(); }
    @NotBlank
    private interface Description { String getDescription(); }

    private interface FullFieldSet extends
            UserAnswerDTO.Id,
            UserAnswerDTO.PassedTestId,
            UserAnswerDTO.QuestionId,
            UserAnswerDTO.AnswerId,
            UserAnswerDTO.LeftPart,
            UserAnswerDTO.Description {}
    private interface FieldSetForCreate extends
            UserAnswerDTO.PassedTestId,
            UserAnswerDTO.QuestionId,
            UserAnswerDTO.AnswerId,
            UserAnswerDTO.LeftPart,
            UserAnswerDTO.Description {}
    private interface FieldSetForUpdate extends
            UserAnswerDTO.LeftPart,
            UserAnswerDTO.Description {}

    public enum Request {;
        @Data
        public static class UserAnswerCreateDTO implements FieldSetForCreate {
            Long passedTestId;
            Long questionId;
            Long answerId;
            String leftPart;
            String description;
        }

        @Data
        public static class UserAnswerUpdateDTO implements FieldSetForUpdate {
            String leftPart;
            String description;
        }
    }

    public enum Response {;
        @Data
        public static class UserAnswerResponseDTO implements FullFieldSet {
            Long id;
            Long passedTestId;
            Long questionId;
            Long answerId;
            String leftPart;
            String description;
        }
    }

}

