package ru.veretennikov.testing.entity.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.TYPE, ElementType.METHOD, ElementType.FIELD })
@Constraint(validatedBy = HasCorrectAnswerMappingValidator.class)
public @interface HasCorrectAnswerMapping {
    String message() default "Для типа вопроса - сопоставление, в ответах должны быть заполнены обе стороны сопоставления";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
