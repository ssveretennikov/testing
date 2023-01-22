package ru.veretennikov.testing.entity.dto.request;

import lombok.Value;

import java.time.LocalDateTime;

public class PassedTestDTO {

//    над методами интерфейсов дописать аннотации валидации, а также документацию
    private interface Id { Long getId(); }

    private interface Test { Test getTest(); }
    private interface UserName { String getUserName(); }
    private interface DateStart { LocalDateTime getDateStart(); }
    private interface DateEnd { LocalDateTime getDateEnd(); }
    private interface TotalQuestion { int getTotalQuestion(); }
    private interface NumCorrect { int getNumCorrect(); }
    private interface TotalWeight { int getTotalWeight(); }
    private interface GainedWeight { int getGainedWeight(); }

    private interface FullFieldSet extends PassedTestDTO.Id, PassedTestDTO.Test, PassedTestDTO.UserName, PassedTestDTO.DateStart, PassedTestDTO.DateEnd,
            PassedTestDTO.TotalQuestion, PassedTestDTO.NumCorrect, PassedTestDTO.TotalWeight, PassedTestDTO.GainedWeight {}
    private interface FullFieldSetWithoutId extends PassedTestDTO.Test, PassedTestDTO.UserName, PassedTestDTO.DateStart, PassedTestDTO.DateEnd,
            PassedTestDTO.TotalQuestion, PassedTestDTO.NumCorrect, PassedTestDTO.TotalWeight, PassedTestDTO.GainedWeight {}

    public enum Request {;
        @Value
        public static class PassedTestCreateDTO implements FullFieldSetWithoutId {
            Test test;
            String userName;
            LocalDateTime dateStart;
            LocalDateTime dateEnd;
            int totalQuestion;
            int numCorrect;
            int totalWeight;
            int gainedWeight;
        }

        @Value
        public static class PassedTestUpdateDTO implements FullFieldSet {
            Long id;
            Test test;
            String userName;
            LocalDateTime dateStart;
            LocalDateTime dateEnd;
            int totalQuestion;
            int numCorrect;
            int totalWeight;
            int gainedWeight;
        }
    }

    public enum Response {;
        @Value
        public static class PassedTestResponseDTO implements FullFieldSet {
            Long id;
            Test test;
            String userName;
            LocalDateTime dateStart;
            LocalDateTime dateEnd;
            int totalQuestion;
            int numCorrect;
            int totalWeight;
            int gainedWeight;
        }
    }

}

