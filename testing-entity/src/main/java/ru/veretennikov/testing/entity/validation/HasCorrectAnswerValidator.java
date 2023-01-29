package ru.veretennikov.testing.entity.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.veretennikov.testing.entity.db.enums.QuestionType;
import ru.veretennikov.testing.entity.dto.AnswerDTO;
import ru.veretennikov.testing.entity.dto.QuestionDTO;

public class HasCorrectAnswerValidator implements ConstraintValidator<HasCorrectAnswerMapping, QuestionDTO.Request.QuestionCreateDTO> {

    @Override
    public boolean isValid(QuestionDTO.Request.QuestionCreateDTO question, ConstraintValidatorContext context) {
        if (question == null)
            return false;
        if (question.getType() != QuestionType.MATCH)
            return question.getAnswers().stream()
                    .anyMatch(AnswerDTO.Request.AnswerCreatePackageDTO::getCorrect);
        return true;
    }

}
