package ru.veretennikov.testing.entity.dto;

import lombok.Data;
import ru.veretennikov.testing.entity.db.enums.QuestionType;
import ru.veretennikov.testing.entity.dto.AnswerDTO.Request.AnswerCreateDTO;
import ru.veretennikov.testing.entity.dto.AnswerDTO.Response.AnswerResponseDTO;

import java.util.List;

public class QuestionDTO {

//    над методами интерфейсов дописать аннотации валидации, а также документацию
    private interface Id { Long getId(); }
    private interface TestId { Long getTestId(); }
    private interface OrderNumber { Integer getOrderNumber(); }
    private interface Weight { Integer getWeight(); }
    private interface Description { String getDescription(); }
    private interface Type { QuestionType getType(); }
    private interface AnswersForCreate { List<AnswerCreateDTO> getAnswers(); }
    private interface AnswersForResponse { List<AnswerResponseDTO> getAnswers(); }

    private interface FullFieldSet extends
            QuestionDTO.Id,
            QuestionDTO.TestId,
            QuestionDTO.OrderNumber,
            QuestionDTO.Weight,
            QuestionDTO.Description,
            QuestionDTO.Type,
            QuestionDTO.AnswersForResponse {}
    private interface FieldSetForCreate extends
            QuestionDTO.TestId,
            QuestionDTO.OrderNumber,
            QuestionDTO.Weight,
            QuestionDTO.Description,
            QuestionDTO.Type,
            QuestionDTO.AnswersForCreate {}
    private interface FieldSetForUpdate extends
            QuestionDTO.OrderNumber,
            QuestionDTO.Weight,
            QuestionDTO.Description,
            QuestionDTO.Type {}

    public enum Request {;
        @Data
        public static class QuestionCreateDTO implements FieldSetForCreate {
            Long testId;
            Integer orderNumber;
            Integer weight;
            String description;
            QuestionType type;
            List<AnswerCreateDTO> answers;
        }

        @Data
        public static class QuestionUpdateDTO implements FieldSetForUpdate {
            Integer orderNumber;
            Integer weight;
            String description;
            QuestionType type;
        }
    }

    public enum Response {;
        @Data
        public static class QuestionResponseDTO implements FullFieldSet {
            Long id;
            Long testId;
            Integer orderNumber;
            Integer weight;
            String description;
            QuestionType type;
            List<AnswerResponseDTO> answers;
        }
    }

}
