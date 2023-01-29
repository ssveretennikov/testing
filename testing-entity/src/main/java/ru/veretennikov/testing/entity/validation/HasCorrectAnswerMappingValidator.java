package ru.veretennikov.testing.entity.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.veretennikov.testing.entity.db.enums.QuestionType;
import ru.veretennikov.testing.entity.dto.QuestionDTO;

import static org.springframework.util.StringUtils.hasText;

public class HasCorrectAnswerMappingValidator implements ConstraintValidator<HasCorrectAnswerMapping, QuestionDTO.Request.QuestionCreateDTO> {

    @Override
    public boolean isValid(QuestionDTO.Request.QuestionCreateDTO question, ConstraintValidatorContext context) {
        if (question == null)
            return false;
        if (question.getType() == QuestionType.MATCH)
            return question.getAnswers().stream()
                    .anyMatch(item -> !(hasText(item.getLeftPart()) && hasText(item.getDescription())));
        return true;
    }

}
