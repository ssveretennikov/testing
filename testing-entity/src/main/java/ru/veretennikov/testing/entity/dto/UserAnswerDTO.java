package ru.veretennikov.testing.entity.dto;

import lombok.Data;

public class UserAnswerDTO {

//    над методами интерфейсов дописать аннотации валидации, а также документацию
    private interface Id { Long getId(); }
    private interface PassedTestId { Long getPassedTestId(); }
    private interface QuestionId { Long getQuestionId(); }
    private interface AnswerId { Long getAnswerId(); }
    private interface LeftPart { String getLeftPart(); }
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

