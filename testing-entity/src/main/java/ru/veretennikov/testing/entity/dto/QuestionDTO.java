package ru.veretennikov.testing.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ru.veretennikov.testing.entity.db.enums.QuestionType;
import ru.veretennikov.testing.entity.dto.AnswerDTO.Request.AnswerCreatePackageDTO;
import ru.veretennikov.testing.entity.dto.AnswerDTO.Response.AnswerResponseDTO;

import java.util.List;

public class QuestionDTO {

//    над методами интерфейсов дописать аннотации валидации, а также документацию
    @NotNull
    @PositiveOrZero
    private interface Id { Long getId(); }
    @NotNull
    @PositiveOrZero
    private interface TestId { Long getTestId(); }
    private interface OrderNumber { Integer getOrderNumber(); }
    private interface Weight { Integer getWeight(); }
    @NotBlank
    private interface Description { String getDescription(); }
    @NotBlank
    private interface Type { QuestionType getType(); }
    @Size(min = 1)
    private interface AnswersForCreate { List<AnswerCreatePackageDTO> getAnswers(); }
    @Size(min = 1)
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
            List<AnswerCreatePackageDTO> answers;
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
