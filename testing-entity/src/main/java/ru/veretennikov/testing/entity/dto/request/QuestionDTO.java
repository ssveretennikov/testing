package ru.veretennikov.testing.entity.dto.request;

import lombok.Value;
import ru.veretennikov.testing.entity.db.Answer;
import ru.veretennikov.testing.entity.db.enums.QuestionType;

import java.util.List;

public class QuestionDTO {

//    над методами интерфейсов дописать аннотации валидации, а также документацию
    private interface Id { Long getId(); }
    private interface Test { Test getTest(); }
    private interface OrderNumber { Integer getOrderNumber(); }
    private interface Weight { Integer getWeight(); }
    private interface Description { String getDescription(); }
    private interface Type { QuestionType getType(); }
    private interface Answers { List<Answer> getAnswers(); }

    private interface FullFieldSet extends QuestionDTO.Id, QuestionDTO.Test, QuestionDTO.OrderNumber, QuestionDTO.Weight, QuestionDTO.Description, QuestionDTO.Type, QuestionDTO.Answers {}
    private interface FullFieldSetWithoutId extends QuestionDTO.Test, QuestionDTO.OrderNumber, QuestionDTO.Weight, QuestionDTO.Description, QuestionDTO.Type, QuestionDTO.Answers {}

    public enum Request {;
        @Value
        public static class QuestionCreateDTO implements FullFieldSetWithoutId {
            Test test;
            Integer orderNumber;
            Integer weight;
            String description;
            QuestionType type;
            List<Answer> answers;
        }

        @Value
        public static class QuestionUpdateDTO implements FullFieldSet {
            Long id;
            Test test;
            Integer orderNumber;
            Integer weight;
            String description;
            QuestionType type;
            List<Answer> answers;
        }
    }

    public enum Response {;
        @Value
        public static class QuestionResponseDTO implements FullFieldSet {
            Long id;
            Test test;
            Integer orderNumber;
            Integer weight;
            String description;
            QuestionType type;
            List<Answer> answers;
        }
    }

}

