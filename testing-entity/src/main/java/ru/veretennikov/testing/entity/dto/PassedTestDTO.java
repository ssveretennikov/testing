package ru.veretennikov.testing.entity.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

public class PassedTestDTO {

//    над методами интерфейсов дописать аннотации валидации, а также документацию
    @NotNull
//    @PositiveOrZero
    private interface Id { Long getId(); }
    @NotNull
//    @PositiveOrZero
    private interface TestId { Long getTestId(); }
//    @NotBlank
    private interface UserName { String getUserName(); }
    @NotNull
//    @Past
    private interface DateStart { LocalDateTime getDateStart(); }
    @NotNull
//    @PastOrPresent
    private interface DateEnd { LocalDateTime getDateEnd(); }
    private interface TotalQuestion { Integer getTotalQuestion(); }
    private interface NumCorrect { Integer getNumCorrect(); }
    private interface TotalWeight { Integer getTotalWeight(); }
    private interface GainedWeight { Integer getGainedWeight(); }

    private interface FullFieldSet extends
            PassedTestDTO.Id,
            PassedTestDTO.TestId,
            PassedTestDTO.UserName,
            PassedTestDTO.DateStart,
            PassedTestDTO.DateEnd,
            PassedTestDTO.TotalQuestion,
            PassedTestDTO.NumCorrect,
            PassedTestDTO.TotalWeight,
            PassedTestDTO.GainedWeight {}
    private interface FieldSetForCreate extends
            PassedTestDTO.TestId,
            PassedTestDTO.UserName,
            PassedTestDTO.DateStart,
            PassedTestDTO.DateEnd,
            PassedTestDTO.TotalQuestion,
            PassedTestDTO.NumCorrect,
            PassedTestDTO.TotalWeight,
            PassedTestDTO.GainedWeight {}
    private interface FieldSetForUpdate extends
            PassedTestDTO.UserName,
            PassedTestDTO.DateStart,
            PassedTestDTO.DateEnd {}

    public enum Request {;
        @Data
        public static class PassedTestCreateDTO implements FieldSetForCreate {
            Long testId;
            String userName;
            LocalDateTime dateStart;
            LocalDateTime dateEnd;
            Integer totalQuestion;
            Integer numCorrect;
            Integer totalWeight;
            Integer gainedWeight;
        }

        @Data
        public static class PassedTestUpdateDTO implements FieldSetForUpdate {
            String userName;
            LocalDateTime dateStart;
            LocalDateTime dateEnd;
        }
    }

    public enum Response {;
        @Data
        public static class PassedTestResponseDTO implements FullFieldSet {
            Long id;
            Long testId;
            String userName;
            LocalDateTime dateStart;
            LocalDateTime dateEnd;
            Integer totalQuestion;
            Integer numCorrect;
            Integer totalWeight;
            Integer gainedWeight;
        }
    }

}
