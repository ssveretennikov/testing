package ru.veretennikov.testing.entity.db.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum QuestionType {
    SELECT_ONE("Выбор одного варианта"),
    SELECT_MULTIPLE("Выбор нескольких вариантов"),
    MATCH("Сопоставление вариантов"),
    TEXT("Ввод текста");

    private final String description;
}
