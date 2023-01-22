package ru.veretennikov.testing.entity.dto.request;

import lombok.Value;

public class UserAnswerDTO {

//    над методами интерфейсов дописать аннотации валидации, а также документацию
    private interface Id { Long getId(); }
    private interface PassedTest { PassedTest getPassedTest(); }
    private interface Question { Question getQuestion(); }
    private interface Answer { Answer getAnswer(); }
    private interface LeftPart { String getLeftPart(); }
    private interface Description { String getDescription(); }

    private interface FullFieldSet extends UserAnswerDTO.Id, UserAnswerDTO.PassedTest, UserAnswerDTO.Question, UserAnswerDTO.Answer, UserAnswerDTO.LeftPart, UserAnswerDTO.Description {}
    private interface FullFieldSetWithoutId extends UserAnswerDTO.PassedTest, UserAnswerDTO.Question, UserAnswerDTO.Answer, UserAnswerDTO.LeftPart, UserAnswerDTO.Description {}

    public enum Request {;
        @Value
        public static class UserAnswerCreateDTO implements FullFieldSetWithoutId {
            ru.veretennikov.testing.entity.db.PassedTest passedTest;
            ru.veretennikov.testing.entity.db.Question question;
            ru.veretennikov.testing.entity.db.Answer answer;
            String leftPart;
            String description;
        }

        @Value
        public static class UserAnswerUpdateDTO implements FullFieldSet {
            Long id;
            ru.veretennikov.testing.entity.db.PassedTest passedTest;
            ru.veretennikov.testing.entity.db.Question question;
            ru.veretennikov.testing.entity.db.Answer answer;
            String leftPart;
            String description;
        }
    }

    public enum Response {;
        @Value
        public static class UserAnswerResponseDTO implements FullFieldSet {
            Long id;
            ru.veretennikov.testing.entity.db.PassedTest passedTest;
            ru.veretennikov.testing.entity.db.Question question;
            ru.veretennikov.testing.entity.db.Answer answer;
            String leftPart;
            String description;
        }
    }

}

