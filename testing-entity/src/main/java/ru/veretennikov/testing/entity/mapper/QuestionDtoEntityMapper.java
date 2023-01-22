package ru.veretennikov.testing.entity.mapper;

import org.mapstruct.Mapper;
import ru.veretennikov.testing.entity.db.Question;
import ru.veretennikov.testing.entity.dto.request.QuestionDTO.Request.QuestionCreateDTO;
import ru.veretennikov.testing.entity.dto.request.QuestionDTO.Request.QuestionUpdateDTO;
import ru.veretennikov.testing.entity.dto.request.QuestionDTO.Response.QuestionResponseDTO;

/**
 * Маппер dto и entity Question
 */
@Mapper(componentModel = "spring")
public interface QuestionDtoEntityMapper {
    QuestionResponseDTO toDto(Question source);
    Question toEntity(QuestionCreateDTO source);
    Question toEntity(QuestionUpdateDTO source);
}


